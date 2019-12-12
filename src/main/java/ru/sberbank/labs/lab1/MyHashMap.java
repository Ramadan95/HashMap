package ru.sberbank.labs.lab1;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyHashMap<K, V> implements IntMap<V> {
	private List<MyEntry<K,V>> list;
	private int size;

	private <K, V> MyHashMap() {
		size = 16;
		list = new ArrayList(size);
		for(int i = 0; i < size; i++) {
			list.add(null);
		}
	}

	@Override
	public V get(int i) {
		int index = getKey(i);
		MyEntry<K, V> entry = list.get(index);
		return entry != null ? list.get(index).getValue() : null;
	}

	@Override
	public V put(int key, V value) {
		int index = getKey(key);
		MyEntry<K,V> entry = new MyEntry(key, value);
		list.add(index, entry);
		return value;
	}

	@Override
	public V remove(int i) {
		int index = getKey(i);
		list.add(index, null);
		return null;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean containsKey(int i) {
		int index = getKey(i);
		return list.get(index) != null;
	}

	@Override
	public boolean containsValue(V o) {
		boolean result = false;
		for(int i = 0; i < size; i++) {
			if (list.get(i) != null && list.get(i).getValue() == o) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void clear() {

	}

	@Override
	public Set<IntEntry<Person>> entrySet() {
		return null;  // I don't understand what needs to be done
	}

	private int getKey(Object key) {
		return Math.abs(key.hashCode() % size); // encrypt the key
	}
}

class MyEntry<K,V> {
	private K key;
	private V value;

	MyEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}