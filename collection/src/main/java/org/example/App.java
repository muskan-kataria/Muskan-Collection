package org.example;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.logging.*;

class MyList<E> extends AbstractList<E>
{
    private static final Logger LOGGER=Logger.getLogger(App.class.getName());
    private static final int INITIAL_CAPACITY=10;
    private static  int ACTUAL_SIZE=0;
    private Object data[];
    private int i;

    MyList()
    {
        data=new Object[INITIAL_CAPACITY];
        i=0;
    }

    @SuppressWarnings("unchecked")
    public E get(int in)
    {
        E x =(E)data[in];
        return x;
    }
    public boolean add(E e)
    {
        data[i]=e;
        i++;

        if(i >= ACTUAL_SIZE)
        {
            increaseListSize();
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index)
    {
        int j;
        Object x=data[index];
        for(j=index;j<ACTUAL_SIZE-1;j++)
        {
            data[j]=data[j+1];
        }
        i--;
        ACTUAL_SIZE--;
        return (E)x;
    }
    public int size()
    {
        return i;
    }
    private void increaseListSize()
    {
        ACTUAL_SIZE = data.length * 2;
        data = Arrays.copyOf(data,ACTUAL_SIZE);
    }
    public void display()
    {
        String s="";
        for (int i = 0; i < this.i; i++)
            s=s+data[i]+" ";
        LOGGER.info(s+"\n");
    }
}

public class App
{
    private static final Logger LOGGER=Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        MyList<Integer> ml = new MyList<Integer>();
        LOGGER.severe(" My List\n");
        for(int i = 0;i<15;i++)
            ml.add(i);

         ml.display();
        ml.remove(3);
        ml.remove(3);
        LOGGER.info("Size of my List :"+ml.size());
        LOGGER.info(" List : \n");
        ml.display();



    }
}
