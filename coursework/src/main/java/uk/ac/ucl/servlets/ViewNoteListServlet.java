package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// The servlet invoked to display a list of notes.
@WebServlet("/noteList.html")
public class ViewNoteListServlet extends HttpServlet
{

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {

    Model model = ModelFactory.getModel();
    List<String> noteNames = model.getNoteNames();

    request.setAttribute("noteNames", noteNames);

    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/noteList.jsp");
    dispatch.forward(request, response);
  }
}
