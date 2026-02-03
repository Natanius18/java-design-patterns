package example.natanius.iterator.iterators;


import example.natanius.iterator.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
