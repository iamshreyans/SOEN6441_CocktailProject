package servlet;

import data.Drinks;
import data.SqlManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class ServletsForDrinks extends HttpServlet {
    public static final long serialVersionUID = 1L;
    private SqlManager sqlManager;

    public ServletsForDrinks() {
        this.sqlManager = new SqlManager();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getServletPath();
        handleGetRequestBasedOnEndpoint(req, res, action);
    }

    private void handleGetRequestBasedOnEndpoint(HttpServletRequest req, HttpServletResponse res, String action) throws ServletException, IOException {
        switch (action) {
            case "/results":
                getResults(req, res);
                break;
            case "/search":
                showSearch(req, res);
                break;
            default:
                listDrinks(req, res);
                break;
        }

        private void getResults (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

            String name = req.getParameter("DrinkName");
            List<Drinks> drinks;
            drinks = sqlManager.searchDrinksByName(name);

            req.setAttribute("listOfDrinks", drinks);
            RequestDispatcher dispatcher = req.getRequestDispatcher("main-screen-drinks-list.jsp");
            dispatcher.forward(req, res);
        }
        private void showSearch (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            RequestDispatcher dispatcher = req.getRequestDispatcher("search-screen.jsp");
            dispatcher.forward(req, res);
        }
        private void listDrinks (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            List<Drinks> drinksList = sqlManager.selectAllDrinks();
            req.setAttribute("listOfDrinks", drinksList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("main-screen-drinks-list.jsp");
            dispatcher.forward(req, res);
        }
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            super.doPost(req, res);
        }
    }
