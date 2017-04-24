#pragma once

#include <iterator>

namespace dbondin {

  template<class T> class SimpleList
  {

  private:

    /* forward declaration */
    struct Node;
    
  public:

    class iterator: public std::iterator<std::forward_iterator_tag, T> {
    public:
      iterator& operator++();
      //iterator operator++(int);
      bool operator==(iterator other);
      bool operator!=(iterator other);
      T operator*() const;
    private:
      iterator(Node * n);
      Node * n;

      friend class SimpleList;
    };
    
    SimpleList();
    virtual ~SimpleList();
    void push_front(const T & value);

    iterator begin();
    iterator end();
    
  private:
    
    struct Node {
      T value;
      Node * next;
    };

    Node * head;
  };
  
};

#include "simplelist.tpp"
