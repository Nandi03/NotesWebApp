package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Updates the file contents of where the note is stored when it's edited and invokes the page with the full updated note.
@WebServlet("/noteEdit.jsp")
public class EditNoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String noteName = request.getParameter("name");
        String newName = request.getParameter("newName");
        String text = request.getParameter("text");
        String url = request.getParameter("url");
        String img = request.getParameter("img");

        Model model = ModelFactory.getModel();

        boolean created = false;

        if(newName.length() == 0) {
            created = false;
        }

        else if(!noteName.equals(newName)){
            created = model.changeName(newName);

        }
        else if(noteName.equals(newName)){
            created = true;
        }

        if(text.length()==0){
            text= "null";
        }

        if (url.length() == 0){
            url = "null";
        }

        if(img.length() == 0){
            img = "null";
        }

        if(created) {
            model.setName(noteName);
            model.updateNote(text, url, img);
            ServletContext context = request.getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/noteLoad.jsp?name=" + newName + "&number=1");
            dispatch.forward(request, response);
        }

        else{
            ServletContext context = request.getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/noteLoad.jsp?name=" + newName + "&number=3");
            dispatch.forward(request, response);
        }
    }

}
