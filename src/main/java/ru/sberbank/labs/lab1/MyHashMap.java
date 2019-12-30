package ru.sberbank.labs.lab1;

import java.util.*;

public class MyHashMap<V extends Comparable> implements IntMap<V> {
    // TODO попробуй использовать Array
    private ArrayList<LinkedList<IntEntry<V>>> buckets;
    private double loadFactory = 0.75;
    private int capacity = 16;
    private int size = 0;
    private int threshold;

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
		ListIterator<IntEntry<V>> iterator = bucket.listIterator();
//      TODO использовать итератор
		if (!bucket.isEmpty()) {
			remove(i);
		}
		iterator.add(new IntEntry<>(i, value));
		increaseSize();
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
        // TODO лишняя проверка
		for (IntEntry<V> e: bucket) {
			if (e.getKey() == i) {
				bucket.remove(e);
				size--;
				break;
			}
        }
		return null;
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
        for (LinkedList<IntEntry<V>> bucket : this.buckets) {
            for (IntEntry<V> e: bucket) {
            	// TODO лучше все же использовать equals
                if (o.compareTo(e.getValue()) == 0) {
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
		transfer(newBuckets, newCapacity);
		this.capacity = newCapacity;
		this.buckets = newBuckets;
		this.threshold = (int)(newCapacity * loadFactory);
	}

	private void transfer(ArrayList<LinkedList<IntEntry<V>>> newBuckets, int newSize) {
		for (LinkedList<IntEntry<V>> bucket : buckets) {
			for (IntEntry<V> e: bucket) {
				int index = indexFor(e.getKey(), newSize);
				newBuckets.get(index).add(e);
			}
		}
	}
}
