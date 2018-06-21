package com.aula5.judson.patrimobi.Dados;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Judson on 21/06/2018.
 */

public class ItemDAO {
    List<Item> items;

    public void InsertItem(int id, String nome, String localizacao){
        Item item = new Item(id, nome, localizacao);
        if(items != null){
            items.add(item);
        }else{
            items = new List<Item>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @NonNull
                @Override
                public Iterator<Item> iterator() {
                    return null;
                }

                @NonNull
                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @NonNull
                @Override
                public <T> T[] toArray(@NonNull T[] a) {
                    return null;
                }

                @Override
                public boolean add(Item item) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(@NonNull Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(@NonNull Collection<? extends Item> c) {
                    return false;
                }

                @Override
                public boolean addAll(int index, @NonNull Collection<? extends Item> c) {
                    return false;
                }

                @Override
                public boolean removeAll(@NonNull Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll(@NonNull Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public Item get(int index) {
                    return null;
                }

                @Override
                public Item set(int index, Item element) {
                    return null;
                }

                @Override
                public void add(int index, Item element) {

                }

                @Override
                public Item remove(int index) {
                    return null;
                }

                @Override
                public int indexOf(Object o) {
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
                    return 0;
                }

                @NonNull
                @Override
                public ListIterator<Item> listIterator() {
                    return null;
                }

                @NonNull
                @Override
                public ListIterator<Item> listIterator(int index) {
                    return null;
                }

                @NonNull
                @Override
                public List<Item> subList(int fromIndex, int toIndex) {
                    return null;
                }
            }
        }
    }
}
