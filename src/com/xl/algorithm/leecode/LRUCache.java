package com.xl.algorithm.leecode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LeetCode 第 146 号问题：LRU缓存机制
 * 题目来源于 LeetCode 上第 146 号问题：LRU缓存机制。题目难度为 Hard，目前通过率为 15.8% 。
 *
 * 题目描述:
 *     运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 *     获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *     写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 *     你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache<K, V> {
    /**
     * class LRUCache{
     * public:
     *     LRUCache(int capacity) {
     *         cap = capacity;
     *     }
     *
     *     int get(int key) {
     *         auto it = m.find(key);
     *         if (it == m.end()) return -1;
     *         l.splice(l.begin(), l, it->second);
     *         return it->second->second;
     *     }
     *
     *     void put(int key, int value) {
     *         auto it = m.find(key);
     *         if (it != m.end()) l.erase(it->second);
     *         l.push_front(make_pair(key, value));
     *         m[key] = l.begin();
     *         if (m.size() > cap) {
     *             int k = l.rbegin()->first;
     *             l.pop_back();
     *             m.erase(k);
     *         }
     *     }
     *
     * private:
     *     int cap;
     *     list<pair<int, int>> l;
     *     unordered_map<int, list<pair<int, int>>::iterator> m;
     * };
     */

    private int capacity;

    private LinkedList<Pair<K, V>> valueList;

    private HashMap<K, V> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        valueList = new LinkedList<Pair<K, V>>();
        hashMap = new HashMap<>();
    }

    public int get(K key) {
        V value = hashMap.get(key);
        int result = 0;
        if (value == null) {
            result = -1;
            System.out.println(-1);
        } else {
            Pair pair = new Pair<>(key, value);
            valueList.remove(pair);
            valueList.add(pair);
            result = 1;
            System.out.println(value);
        }

        return result;
    }

    public void put(K key, V value) {
        if (hashMap.containsKey(key)) {
            hashMap.put(key, value);
            Pair pair = new Pair<>(key, value);
            valueList.remove(pair);
            valueList.add(pair);
        } else {
            if (valueList.size() == capacity) {
                Pair<K, V> rmItem = valueList.remove(0);
                hashMap.remove(rmItem.getKey());
            }
            hashMap.put(key, value);
            valueList.add(new Pair<>(key, value));
        }
    }

    public static void main(String[] args) {
//        LRUCache<Integer, Integer> cache = new LRUCache( 2 /* 缓存容量 */ );
        LRUCache2<Integer, Integer> cache = new LRUCache2( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}


class LRUCache2<K, V> {
    private int capacity;
    private LinkedHashMap<K, V> hashMap;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        hashMap = new LinkedHashMap<>();
    }

    public V get(K key) {
        V value = hashMap.get(key);
        if (value == null) {
            System.out.println(-1);
        } else {
            hashMap.remove(key);
            hashMap.put(key, value);
            System.out.println(value);
        }

        return value;
    }

    public void put(K key, V value) {
        if (hashMap.containsKey(key)) {
            hashMap.remove(key);
            hashMap.put(key, value);
        } else {
            if (hashMap.size() == capacity) {
                Map.Entry<K, V> head = getHead(hashMap);
                hashMap.remove(head.getKey());
            }
            hashMap.put(key, value);
        }
    }

    public Map.Entry<K, V> getHead(LinkedHashMap<K, V> map) {
        return map.entrySet().iterator().next();
    }
}