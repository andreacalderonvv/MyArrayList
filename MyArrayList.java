/*Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources Used: write up, quiz 1, zybooks chapter 2, lecture worksheet
 * 
 * This file serves the purpose of trying to implement methods for an array.
 * It includes methods to add, remove, prepend and more.
 */

 /*This class implements MyList and holds all the method bodies */

public class MyArrayList<E> implements MyList<E> {

  

    // instance variables

    Object[] data;
    int size;
    public MyArrayList(){
        this.data = new Object[5];
    }
    public MyArrayList(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        else{
            this.data = new Object[initialCapacity];
        }
    }
    public MyArrayList (E[] arr){
        if(arr==null){
            this.data = new Object[5];
        }
        else{
            this.data = arr;
            size=arr.length;
        }
    }

    /* This method expands the capcity of the array if it needs more space.*/


    public void expandCapacity (int requiredCapacity){
        if(requiredCapacity > data.length){
            if (data.length+3 < requiredCapacity){
                Object[] newArray = new Object[requiredCapacity];
                for(int i=0; i < data.length;i++){
                    newArray[i]=data[i];
                }
                data = newArray;
            }
            else if(data.length > 0){
                Object[] newArray = new Object[data.length+3];
                for(int i=0; i < data.length;i++){
                    newArray[i]=data[i];
                }
                data = newArray;
            }
            else if(data.length==0){
                Object[] newArray = new Object[5];
                for(int i=0; i < data.length;i++){
                    newArray[i]=data[i];
            }
                data = newArray;
            }
        }
        else{
            throw new IllegalArgumentException();
        }
        
    }

    public int getCapacity(){
        return data.length;
    }

    public void insert(int index, E element){// NOT DONE!!!!!!!!!!!!!!!!!!!!!!!!!
        if(size==data.length){
            expandCapacity(data.length+1);
        }
        if(index < 0 || index > data.length){
            throw new IndexOutOfBoundsException();

        }
        else{
            for (int i=data.length-1; i > index;i--){
                data[i]= data[i-1];
            }
            data[index]=element;
            size++;
        }
    }

    public void append(E element){
        if(size == data.length){
            expandCapacity(data.length+1);
        }
        data[size]=element;
        size++;
    }

    public void prepend(E element){
        if(size==data.length){
            expandCapacity(data.length+1);
        }
        for (int i=data.length-1; i > 0;i--){
            data[i]= data[i-1];
        }
        size++;
        data[0]=element;


    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        return (E) data[index];
    }


    @SuppressWarnings("unchecked")
    public E set(int index, E element){
        if (index < 0 || index > data.length){
            throw new IndexOutOfBoundsException();
        }
        E temp = (E) data[index];
        data[index]=element;
        return temp;
        
    }

    @SuppressWarnings("unchecked")
    public E remove(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        E temp;
        temp = (E) data[index];
        for(int i= index; i < data.length-1; i++){
            data[i]=data[i+1];
        }
        size--;
        data[data.length-1]=null;
        return temp;
    }

    public int size(){
        return size;
    }

}
