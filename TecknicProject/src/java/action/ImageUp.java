/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
@MultipartConfig
public class ImageUp extends ActionSupport {
    private String link;
    private File file;
    private String fileContentType;
    private String fileFileName;
    private static final long serialVersionUID = 1L;
    public ImageUp() {
    }

    @Action(value = "/upload_img", results = {
        @Result(name = "success", type = "json"),
        @Result(name = "input", type = "json")
    })
    public String execute() throws Exception {
        // The route on which the file is saved.
        ServletContext context = ServletActionContext.getServletContext();
        File uploads = new File(context.getRealPath("/") + "/files");
//        uploads = new File("/img");
        // duong dan luu file
        String multipartContentType = "multipart/form-data";
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest();
        Map< Object, Object> responseData = null;

        // Create path components to save the file.
//        final PrintWriter writer = response.getWriter();

        String linkName = null;
        String name = null;

        try {
            // Check content type.
            if (request.getContentType() == null
                    || request.getContentType().toLowerCase().indexOf(multipartContentType) == -1) {

                throw new Exception("Invalid contentType. It must be " + multipartContentType);
            }

            // Get file Part based on field name and also image extension.
//            filePart = request.getPart(fieldname);
            String type = fileContentType;
            type = type.substring(type.lastIndexOf("/") + 1);

            // Generate random name.
            String extension = type;
            extension = (extension != null && extension != "") ? "." + extension : extension;
            name = UUID.randomUUID().toString() + extension;

            // Get absolute server path.
            String absoluteServerPath = uploads + name;

            // Create link.
            String path = request.getHeader("referer");
            linkName = "/Tecknic/files/" + name;

            // Validate image.
            String mimeType = fileContentType;
            String[] allowedExts = new String[]{
                "gif",
                "jpeg",
                "jpg",
                "png",
                "svg",
                "blob"
            };
            String[] allowedMimeTypes = new String[]{
                "image/gif",
                "image/jpeg",
                "image/pjpeg",
                "image/x-png",
                "image/png",
                "image/svg+xml"
            };

            if (!ArrayUtils.contains(allowedExts, FilenameUtils.getExtension(absoluteServerPath))
                    || !ArrayUtils.contains(allowedMimeTypes, mimeType.toLowerCase())) {

                // Delete the uploaded image if it dose not meet the validation.
                File file = new File(uploads + name);
                if (file.exists()) {
                    file.delete();
                }

                throw new Exception("Image does not meet the validation.");
            }

            // Save the file on server.
            File fileCreate = new File(uploads, name);

            try {
                FileUtils.copyFile(file, fileCreate);
            } catch (Exception e) {
                e.printStackTrace();
//                writer.println("<br/> ERROR: " + e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location." + "<br/> ERROR: " + e.getMessage());
//            writer.println("You either did not specify a file to upload or are "
//                    + "trying to upload a file to a protected or nonexistent "
//                    + "location.");
//            writer.println("<br/> ERROR: " + e.getMessage());
            responseData = new HashMap< Object, Object>();
            responseData.put("error", e.toString());

        } finally {
            // Build response data.
            responseData = new HashMap< Object, Object>();
            responseData.put("link", linkName);

            // Send response data.
            String jsonResponseData = new Gson().toJson(responseData);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(jsonResponseData);
            link = linkName;
        }
        return SUCCESS;
    }

    public String getLink() {
        return link;
    }

    public void setFile(File file) {
        this.file = file;
    }


    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }


    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    
}

