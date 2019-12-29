package ru.sberbank.labs.lab1;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MyHashMapTest {
    @Test
    public void size() {
        MyHashMap<Integer> map = new MyHashMap<>();
        for(int i = 0; i < 1000; i++) {
            assertEquals(i, map.size());
            map.put(i, i);
        }
    }

    @Test
    public void put() {
        MyHashMap<Integer> myMap = new MyHashMap<>(4);
        HashMap<Integer, Integer> map = new HashMap<>(4);

        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 5);
        map.put(4, 4);
        map.put(3, 7);

        myMap.put(1, 1);
        myMap.put(2, 3);
        myMap.put(3, 5);
        myMap.put(4, 4);
        myMap.put(3, 7);

        assertTrue(map.entrySet().containsAll(myMap.entrySet()));
    }


    @Test
    public void get() {
        MyHashMap<Integer> myMap = new MyHashMap<>(4);
        HashMap<Integer, Integer> map = new HashMap<>(4);

        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 5);
        map.put(4, 4);
        map.put(3, 7);

        myMap.put(1, 1);
        myMap.put(2, 3);
        myMap.put(3, 5);
        myMap.put(4, 4);
        myMap.put(3, 7);

        map.remove(1);
        map.remove(2);
        map.remove(4);

        myMap.remove(1);
        myMap.remove(2);
        myMap.remove(4);

        assertEquals(map.get(2), map.get(2));
    }

    @Test
    public void remove() {
        MyHashMap<Integer> myMap = new MyHashMap<>(4);
        HashMap<Integer, Integer> map = new HashMap<>(4);

        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 5);
        map.put(4, 4);
        map.put(3, 7);

        myMap.put(1, 1);
        myMap.put(2, 3);
        myMap.put(3, 5);
        myMap.put(4, 4);
        myMap.put(3, 7);

        map.remove(1);
        map.remove(2);
        map.remove(4);

        myMap.remove(1);
        myMap.remove(2);
        myMap.remove(4);

        assertTrue(map.entrySet().containsAll(myMap.entrySet()));
    }

    @Test
    public void clear() {
        MyHashMap<Integer> myMap = new MyHashMap<>(4);
        HashMap<Integer, Integer> map = new HashMap<>(4);

        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 5);
        map.put(4, 4);
        map.put(3, 7);

        myMap.put(1, 1);
        myMap.put(2, 3);
        myMap.put(3, 5);
        myMap.put(4, 4);
        myMap.put(3, 7);

        map.clear();
        myMap.clear();

        assertTrue(map.entrySet().containsAll(myMap.entrySet()));
    }


    @Test
    public void isEmpty() {
        MyHashMap<Integer> map = new MyHashMap<>();
        assertTrue(map.isEmpty());
        map.put(1,1);
        assertFalse(map.isEmpty());
    }

    @Test
    public void containsKey() {
        MyHashMap<Integer> map = new MyHashMap<>();
        assertFalse(map.containsKey(1));
        for (int i = 0; i < 10000; i++){
            map.put(i, i);
        }
        for (int i = 0; i < 10000; i++){
            assertTrue(map.containsKey(i));
        }
        for (int i = 10001; i < 20000; i++){
            assertFalse(map.containsKey(i));
        }
    }

    @Test
    public void containsValue() {
        MyHashMap<Integer> map = new MyHashMap<>();
        assertFalse(map.containsValue(1));
        for (int i = 0; i < 10000; i++){
            map.put(i, i);
        }
        for (int i = 0; i < 10000; i++){
            assertTrue(map.containsValue(i));
        }
        for (int i = 10001; i < 20000; i++){
            assertFalse(map.containsValue(i));
        }
    }

    @Test
    public void entrySet() {
        int size = 100;
        MyHashMap<Person> myHashMap = new MyHashMap<>();
        Comf comf = new Comf();
        int[]       digs = comf.generateIntegers(size);
        Person[]    persons = comf.generatePerson(size);

        Set<IntEntry<Person>> entrySet = new HashSet<>();
        for (int i = 0; i < size; i++){
            entrySet.add(new IntEntry<>(digs[i], persons[i]));
            myHashMap.put(digs[i], persons[i]);
        }
        assertTrue(entrySet.containsAll(myHashMap.entrySet()));
    }
}

