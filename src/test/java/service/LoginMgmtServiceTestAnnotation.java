package service;

import dao.ILoginDAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LoginMgmtServiceTestAnnotation {
    @InjectMocks
    private  LoginMgmtServiceImpl loginService;
    @Mock
    private static ILoginDAO loginDAOMock;

    @Spy
    private static ILoginDAO loginDAOSpy;

    public LoginMgmtServiceTestAnnotation(){
        MockitoAnnotations.openMocks(this); // call this method in @Before or constructor TestCase class in order to activate Mockito Annotations
    }

    //Test methods
    @Test
    public void testLoginWithValidCredentials() {
        //Provide Stud (Temporary functionalities) for DAO's authenticate method
//        Mockito.when(loginDAOMock.authenticate("ram", "shyam")).thenReturn(1);
        BDDMockito.given(loginDAOMock.authenticate("ram", "shyam")).willReturn(1); // agile/JIRA
        //Unit Testing
        assertTrue(loginService.login("ram", "shyam"));
    }

    @Test
    public void testLoginWithInValidCredentials() {
        //Provide Stud (Temporary functionalities) for DAO's authenticate method
        Mockito.when(loginDAOMock.authenticate("ram", "shyam1")).thenReturn(0);
        //Unit Testing
        assertFalse(loginService.login("ram", "shyam1"));
    }

    @Test
    public void testLoginWithNoCredentials() {
        assertThrows(IllegalArgumentException.class,
                () -> loginService.login("", ""));
    }

    @Test
    public void testRegisterWithSpy() {
        ILoginDAO loginDAOSpy = Mockito.spy(ILoginDAO.class);
        ILoginMgmtService loginService = new LoginMgmtServiceImpl(loginDAOSpy);
        loginService.registerUser("ram", "admin");
        loginService.registerUser("shyam", "visitor");
        loginService.registerUser("sita", "");

        Mockito.verify(loginDAOSpy, Mockito.times(1)).addUser("ram", "admin");// check the above register method calls adduser(-,-) is called for 1 time internally or not for the inputs "ram","admin"
        Mockito.verify(loginDAOSpy, Mockito.times(0)).addUser("shyam", "visitor");
        Mockito.verify(loginDAOSpy, Mockito.never()).addUser("sita", "");


    }
}
