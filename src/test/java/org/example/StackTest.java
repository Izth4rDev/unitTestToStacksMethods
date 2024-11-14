package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
         stack = new Stack<>(2);
    }

    // 1- crear stack
    @Test
    void createStack() {
       assertNotNull(new Stack<>(2));
    }
    // 2- hacer un push
    @Test
    void makeAPushInTotheStack() {
        assertTrue(stack.push(1));
    }

    // 3- Obtener el size de un stack nuevo
    @Test
    void obtainSizeFromNewStack() {
        assertEquals(0, stack.size());
    }

    // 4- Obtener size despues de realizar un push
    @Test
    void obtainSizeFromStackWhenPushed() {
        stack.push(1);
        assertEquals(1, stack.size());
    }

    // 5- Obtener size despues de un push push
    @Test
    void obtainSizeFromStackWhenPushTwice(){
        stack.push(1);
        stack.push(2);
        assertEquals(2,stack.size());
    }

    // 6- Hacer pop al stack
    @Test
    void returnedValuePopFromStack(){
        stack.push(1);
        stack.push(33);
        assertEquals(33, stack.pop());
    }

    // 6.2- obetener el size despues de un pop
    @Test
    void returnedSizeAfterPopFromStack(){
        stack.push(1);
        stack.push(3);
        stack.pop();
        assertEquals(1, stack.size());
    }

    // 7- hacer push y pop
    @Test
    void returnedValueFromStackAfterPushThenPop(){
        stack.push(1);
        var popped = stack.pop();
        assertEquals(1, popped);
    }

    // 8- hacer peek al stack
    @Test
    void obtainValueFromStackWhenWePeek(){
        stack.push(1);
        assertEquals(1, stack.peek() );
    }

    // 8.2- hacer peek y obtener el size(no disminuir el size)
    @Test
    void obtainSizeFromStackAfterPeek(){
        stack.push(1);
        stack.push(3);
        stack.peek();
        assertEquals(2, stack.size());
    }

    // 9- hacer push, peek, size
    @Test
    void obtainSizeFromStackBeforePushPeek(){
        stack.push(1);
        stack.peek();
        assertEquals(1, stack.size());
    }

    // 10- hacer push, push, pop,pop
    @Test
    void obtainValueFromStackAfterPushTPushTPopTpop(){
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    // 11- hacer push, pop, push, pop
    @Test
    void obtainValueFromStackAfterPushTpopTpushTpop(){
        stack.push(1);
        assertEquals(1, stack.pop());
        stack.push(2);
        assertEquals(2, stack.pop());
    }

    // 12- hacer maxSize
    @Test
    void addMaxSizeToStack(){
        stack.push(1);
        stack.push(2);
        int maxSize = stack.getMaxSize();
        assertEquals( maxSize,stack.size());
    }

    // 13- hacer maxSize + 1
    @Test
    void throwExeptionAfterPushingOvertheMaxSizeOfStack(){
        stack.push(1);
        stack.push(3);
        assertThrows(StackOverflowError.class, () -> stack.push(5));
    }

    // 14- asegurarnos que el metodo push solo inserte en el stack
    // solo y solo si el elemento no existe en el stack
    @Test
    void makeSureTheElementIsNotInTheStackBeforePushing(){
        stack.push(2);
        assertFalse(stack.push(2));
    }

}