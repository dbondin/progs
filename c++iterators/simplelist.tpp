#include <cstddef>

namespace dbondin {

  template<class T>
  SimpleList<T>::SimpleList() : head(NULL) {
  }

  template<class T>
  SimpleList<T>::~SimpleList() {
    Node * n = this->head;
    while(n != NULL) {
      Node * next = n->next;
      delete n;
      n = next;
    }
  }

  template<class T>
  void
  SimpleList<T>::push_front(const T & value) {
    Node * n = new Node();
    n->value = value;
    n->next = this->head;
    this->head = n;
  }

  template<class T>
  typename SimpleList<T>::iterator
  SimpleList<T>::begin() {
    return SimpleList<T>::iterator(this->head);
  }
  
  template<class T>
  typename SimpleList<T>::iterator
  SimpleList<T>::end() {
    return SimpleList<T>::iterator(NULL);
  }

  template<class T>
  SimpleList<T>::iterator::iterator(Node * n) {
    this->n = n;
  }
  
  template<class T>
  typename SimpleList<T>::iterator&
  SimpleList<T>::iterator::operator++() {
    this->n = this->n->next;
    return *this;
  }

  template<class T>
  bool
  SimpleList<T>::iterator::operator==(iterator other) {
    return this->n == other.n;
  }
  
  template<class T>
  bool
  SimpleList<T>::iterator::operator!=(iterator other) {
    return !(*this == other);
  }
  
  template<class T>
  T
  SimpleList<T>::iterator::operator*() const {
    return this->n->value;
  }

}
