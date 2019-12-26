package ru.sberbank.labs.lab1;


import java.util.LinkedList;
import java.util.Set;
// TODO Итоговое заключение:
// 1. Все конечно прекрасно, но что будет если 2 ключа имеют одинаковый хэш
// 2. Попробуй использовать Stream API вместо циклов
// TODO Что такое тип K? Где он используется? TODO Дженерик, который будет заменен на тип, который подадут --//-- Написал по привычне, забыв, что у нас ключ всегда int
public class MyHashMap<V extends Comparable> implements IntMap<V> {
	private float loadfactor = 0.75f;
	private int capacity = 100;
	private int size = 0;
	private IntEntry<V> buckets[] = new IntEntry[capacity];

	private int hashing(int hashCode) {
		int location = hashCode % capacity;
//		System.out.println("Location:"+location);
		return location;
	}

	@Override
	public V get(int i) {
		V ret = null;
		int location = hashing(hashCode());
		IntEntry<V> e = null;
		try{
			e = buckets[location];
		}catch(NullPointerException ex) {
			ex.getMessage();
		}
		if(e!= null && e.getKey() == i) {
			return e.getValue();
		}
		return ret;
	}

	@Override
	public V put(int key, V value) {
		V ret = null;
		int location = hashing(hashCode() % key);
		if (location >= capacity) {
			System.out.println("Rehashing required");
			return null;
		}
		IntEntry<V> e = null;
		try {
			e = buckets[location];
		} catch (NullPointerException ex) {

		}
		if (e != null && e.getKey() == key) {
			ret = e.getValue();
		} else {
			IntEntry<V> eNew = new IntEntry<>(key, value);
			buckets[location] = eNew;
			size++;
		}
		return ret;
	}

	@Override
	public V remove(int i) {
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
//		if (this.size == 0) {
//			return true;
//		}
//		return false;
		return ((this.size == 0) ? true : false);
	}

	@Override
	public boolean containsKey(int i) {
		return true;
	}

	@Override
	public boolean containsValue(V value) {
		for(int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null && buckets[i].getValue() == value) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public Set<IntEntry<Person>> entrySet() {
		return null;
	}
}
