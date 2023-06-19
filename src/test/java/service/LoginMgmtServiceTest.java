package service;

import dao.ILoginDAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class LoginMgmtServiceTest {
        private static ILoginMgmtService loginService;
        private static ILoginDAO loginDAOMock;

        @BeforeAll
        public static void setUpOnce(){
            //create MOCK/ FAKE/ Dummy object
            loginDAOMock= Mockito.mock(ILoginDAO.class); //mock(-) generates InMemory class implementing ILoginDAO(I) having null method definitions for authenticate(-,-) method

            System.out.println(loginDAOMock.getClass() + " " + Arrays.toString(loginDAOMock.getClass().getInterfaces()));
            //create service class object
            loginService=new LoginMgmtServiceImpl(loginDAOMock);
        }

        @AfterAll
        public static void clearOnce(){
            loginDAOMock=null;
            loginService=null;
        }

        //Test methods
    @Test
    public void testLoginWithValidCredentials(){
            //Provide Stud (Temporary functionalities) for DAO's authenticate method
//        Mockito.when(loginDAOMock.authenticate("ram", "shyam")).thenReturn(1);
        doReturn(1).when(loginDAOMock).authenticate("ram", "shyam");
        //Unit Testing
        assertTrue(loginService.login("ram", "shyam"));
    }

    @Test
    public void testLoginWithInValidCredentials(){
        //Provide Stud (Temporary functionalities) for DAO's authenticate method
        Mockito.when(loginDAOMock.authenticate("ram", "shyam1")).thenReturn(0);
        //Unit Testing
        assertFalse(loginService.login("ram", "shyam1"));
    }

    @Test
    public void testLoginWithNoCredentials(){
        assertThrows(IllegalArgumentException.class,
                () -> loginService.login("",""));
    }

    @Test
    public void testRegisterWithSpy(){
            ILoginDAO loginDAOSpy=Mockito.spy(ILoginDAO.class);
            ILoginMgmtService loginService=new LoginMgmtServiceImpl(loginDAOSpy);
            loginService.registerUser("ram", "admin");
            loginService.registerUser("shyam", "visitor");
        loginService.registerUser("sita", "");

        Mockito.verify(loginDAOSpy, Mockito.times(1)).addUser("ram","admin");// check the above register method calls adduser(-,-) is called for 1 time internally or not for the inputs "ram","admin"
        Mockito.verify(loginDAOSpy, Mockito.times(0)).addUser("shyam","visitor");
        Mockito.verify(loginDAOSpy, Mockito.never()).addUser("sita","");
    }
}