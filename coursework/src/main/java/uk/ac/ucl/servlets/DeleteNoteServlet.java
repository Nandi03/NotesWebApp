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

// Deletes a note of a given name and invokes the page with updated list of notes.
@WebServlet("/deleteNote.jsp")
public class DeleteNoteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String noteName = request.getParameter("name");

        Model model = ModelFactory.getModel();
        model.setName(noteName);
        model.deleteNote();

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/noteList.html");
        dispatch.forward(request, response);
    }

}