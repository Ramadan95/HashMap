package ru.sberbank.labs.lab1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
// TODO Итоговое заключение:
// 1. Все конечно прекрасно, но что будет если 2 ключа имеют одинаковый хэш
// 2. Попробуй использовать Stream API вместо циклов
// TODO Что такое тип K? Где он используется?
public class MyHashMap<V extends Comparable> implements IntMap<V> {
	private ArrayList<LinkedList<IntEntry<V>>> buckets;
	private double	loadFactory = 0.75;
	private int		capacity = 16;
	private int		size = 0;
	private int		threshold;

	MyHashMap() {
		buckets = new ArrayList<>(capacity);
		threshold = (int) (capacity * loadFactory);
		for (int i = 0; i < capacity; i++) {
			buckets.add(new LinkedList<>());
		}
	}

	MyHashMap(int capacity) {
		this.capacity = capacity;
		threshold = (int) (capacity * loadFactory);
        buckets = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			buckets.add(new LinkedList<>());
		}
	}

	MyHashMap(int capacity, double loadFactory) {
		this.capacity = capacity;
		this.loadFactory = loadFactory;
		threshold = (int) (capacity * loadFactory);
        buckets = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			buckets.add(new LinkedList<>());
		}
	}

	@Override
	public V put(int i, V value) {
	    LinkedList<IntEntry<V>> bucket = buckets.get(indexFor(i, capacity));
        if (bucket.isEmpty()) {
            bucket.add(new IntEntry<>(i, value));
            increaseSize();
        }
        else {
			for (IntEntry<V> e: bucket) {
				if (e.getKey() == i) {
					bucket.remove(e);
					decreaseSize();
				}
			}
			bucket.add(new IntEntry<>(i, value));
			increaseSize();
		}
        return value;
	}

	@Override
	public V get(int key) {
		LinkedList<IntEntry<V>> bucket = buckets.get(indexFor(key, capacity));
		for (IntEntry<V> e: bucket) {
			if (e.getKey() == key) {
				return e.getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(int i) {
	    LinkedList<IntEntry<V>> bucket = buckets.get(indexFor(i, capacity));
        if (!bucket.isEmpty()) {
            for (IntEntry<V> e: bucket) {
                if (e.getKey() == i) {
                    buckets.remove(i);
                    size--;
                }
            }
        }
		return bucket.get(indexFor(i, capacity)).getValue();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(int i) {
		LinkedList<IntEntry<V>> bucket = buckets.get(indexFor(i, capacity));
		for (IntEntry<V> e: bucket) {
			if (e.getKey() == i) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(V o) {
        for (LinkedList<IntEntry<V>> bucket : buckets) {
            for (IntEntry<V> e: bucket) {
                if (e.getValue() == o) {
                    return true;
                }
            }
        }
		return false;
	}


	@Override
	public void clear() {
        buckets.clear();
        size = 0;
	}

	// TODO Нужно вернуть все элементы структуры данных
	@Override
	public Set<IntEntry<Person>> entrySet() {
		Set<IntEntry<Person>> set = new HashSet<>();
        for (LinkedList<IntEntry<V>> bucket : buckets) {
            for (IntEntry<V> e: bucket) {
                set.add((IntEntry<Person>)e);
            }
        }
		return set;
	}

	private static int indexFor(int h, int capacity)
	{
		return h & (capacity - 1);
	}

	private void increaseSize() {
		size++;
		if (size >= threshold)
			resize(capacity * 2);
	}

	private void decreaseSize() {
		size--;
	}

	private void resize(int newCapacity) {
		ArrayList<LinkedList<IntEntry<V>>> newBuckets = new ArrayList<>(newCapacity);
		for (int i = 0; i < newCapacity; i++) {
			newBuckets.add(new LinkedList<>());
		}
		transfer(newBuckets);
		this.buckets = newBuckets;
		this.capacity = newCapacity;
		this.threshold = (int)(newCapacity * loadFactory);
	}

	private void transfer(ArrayList<LinkedList<IntEntry<V>>> newBuckets) {
		for (LinkedList<IntEntry<V>> bucket : newBuckets) {
			for (IntEntry<V> e: bucket) {
				int index = indexFor(e.getKey(), newBuckets.size());
				newBuckets.get(index).add(e);
			}
		}
	}
}