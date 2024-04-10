import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Contact> contacts;

    public ContactServlet() {
        super();
        contacts = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Contact contact = new Contact(name, email, phone);
        contacts.add(contact);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Convert contacts list to JSON and send it as response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(contactsToJson());
    }

    private String contactsToJson() {
        StringBuilder json = new StringBuilder("[");
        for (Contact contact : contacts) {
            json.append("{");
            json.append("\"name\":\"").append(contact.getName()).append("\",");
            json.append("\"email\":\"").append(contact.getEmail()).append("\",");
            json.append("\"phone\":\"").append(contact.getPhone()).append("\"");
            json.append("},");
        }
        if (!contacts.isEmpty()) {
            json.deleteCharAt(json.length() - 1); // Remove the last comma
        }
        json.append("]");
        return json.toString();
    }
}