package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class MockvsSpyTest {
    @Test
    public void testList() {
        List<String> listMock = Mockito.mock(ArrayList.class); //Mock
        // List<String> listSpy= Mockito.spy(ArrayList.class); //Spy
        List<String> listSpy = Mockito.spy(new ArrayList()); //Spy
        listMock.add("table");
        Mockito.when(listMock.size()).thenReturn(10); //stub on Mock obj
        listSpy.add("table");
        Mockito.when(listSpy.size()).thenReturn(10); //stub on Spy obj
        System.out.println(listMock.size() + " " + listSpy.size());
    }
}
