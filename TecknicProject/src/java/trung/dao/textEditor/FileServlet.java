/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.dao.textEditor;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
//@WebServlet("/files/*")
@WebServlet(name = "FileDownloadServlet", urlPatterns = {
    "/index.jspfiles/*", "/files/*"
})
public class FileServlet extends HttpServlet {
 
private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
        File file = new File("..\\..\\NetbeanProject\\TestEditor2\\web\\img\\", filename);
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        System.out.println("Path: " + file.toPath());
        System.out.println("File name: " + filename);
        Files.copy(file.toPath(), response.getOutputStream());
    }
}