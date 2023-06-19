package service;

import dao.ILoginDAO;

public class LoginMgmtServiceImpl implements ILoginMgmtService {
    private ILoginDAO loginDAO;

    public LoginMgmtServiceImpl(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public boolean login(String username, String password) {
        if (username.equals("") || password.equals("")) throw new IllegalArgumentException("empty credentials");
        //use LoginDAO
        int count = loginDAO.authenticate(username, password);
        System.out.println("Service login count:" + count);
        if (count == 0)
            return false;
        else
            return true;
    }

    public String registerUser(String user, String role) {
        if (!role.equalsIgnoreCase("") && !role.equalsIgnoreCase("visitor")) {
            loginDAO.addUser(user, role);
            return "User added";
        } else
            return "User not added";
    }
}
