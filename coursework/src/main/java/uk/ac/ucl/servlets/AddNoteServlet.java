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

// The servlet invoked to create a new note given a name for the note and invokes the editing page.
@WebServlet("/addNote.jsp")
public class AddNoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String noteName = request.getParameter("name");

        request.setAttribute("name", noteName);
        
        Model model = ModelFactory.getModel();
        model.setName(noteName);

        boolean created;
        if (noteName.length() != 0) {
            created = model.createNote(noteName);
        } else {
            created = false;
        }
        if (created) {
            model.updateNote("null", "null", "null");
            model.addName();
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/editNote.jsp");
            dispatch.forward(request, response);
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/noteAddTryAgain.jsp");
            dispatch.forward(request, response);
        }


    }
}
