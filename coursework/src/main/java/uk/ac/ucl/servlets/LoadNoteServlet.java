package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Note;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Retrieve data of the note and forward to either the editing page or the full note page to display note's contents.
@WebServlet("/noteLoad.jsp")
public class LoadNoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String noteName = request.getParameter("name");
        String number = request.getParameter("number");

        Note note = new Note(noteName);
        request.setAttribute("name", note.getName());
        request.setAttribute("text", note.getText());
        request.setAttribute("img", note.getImage());
        request.setAttribute("url", note.getUrl());

        if (number.equals("1")) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/noteData.jsp");
            dispatch.forward(request, response);
        } else if (number.equals("2")) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/editNote.jsp");
            dispatch.forward(request, response);
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/editNoteTryAgain.jsp");
            dispatch.forward(request, response);
        }
    }

}
