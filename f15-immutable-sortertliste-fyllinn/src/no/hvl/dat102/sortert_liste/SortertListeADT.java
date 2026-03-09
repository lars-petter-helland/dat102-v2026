package no.hvl.dat102.sortert_liste;
/** 
   An interface for the ADT sorted list.
   Entries in the list have positions that begin with 1.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface SortertListeADT<T extends Comparable<? super T>>
{
   /** Adds a new entry to this sorted list in its proper order.
       The list's size is increased by 1.
       @param newEntry  The object to be added as a new entry. */
   public void add(T newEntry);
   
   /** Removes the first or only occurrence of a specified entry
       from this sorted list.
       @param anEntry  The object to be removed.
       @return  True if anEntry was located and removed; 
                otherwise returns false. */
   public boolean remove(T anEntry);
   
   /** Gets the position of an entry in this sorted list.
       @param anEntry  The object to be found.
       @return  The position of the first or only occurrence of anEntry
                if it occurs in the list; otherwise returns the position
                where anEntry would occur in the list, but as a negative
                integer. */
   public int getPosition(T anEntry);
   
   // The following methods are described in Segment 10.9 of Chapter 10
   // as part of the ADT list:
   
   public T getEntry(int givenPosition);
   public boolean contains(T anEntry);
   public T remove(int givenPosition);
   public void clear();
   public int getLength();
   public boolean isEmpty();
   public T[] toArray();
} // end SortedListInterface
