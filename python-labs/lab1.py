#!/usr/bin/env python3

import ctypes
import sys

class FIUnion(ctypes.Union):
    _fields_ = [("i", ctypes.c_uint32),("f", ctypes.c_float)]

def f2bistr():
    print("f2bistr")
    fi = FIUnion()
    fi.f = float(input("input float number: "))
    print("f {} {}".format(type(fi.f), fi.f))
    print("i {} {}".format(type(fi.i), fi.i))
    mask = 0x80000000
    for i in range(1, 33):
        print("{}".format(0 if (0 == (fi.i & mask)) else 1), end="")
        if i == 1 or i == 9:
            print(" ", end="")
        mask = mask >> 1
    print()
    return

def bistr2f():
    print("bistr2f")
    print("               SeeeeeeeeMMMMMMMMMMMMMMMMMMMMMMM")
    s = input("input 32 bits: ")
    if len(s) != 32:
        print("Error: must be 32 bits", file=sys.stderr)
        return
    fi = FIUnion()
    fi.i = 0
    mask = 0x80000000
    for c in s:
        if c != "0" and c != "1":
            print("Error: bad symbol '{}' in bitstring".format(c), file=sys.stderr)
            return
        if c == "1":
            fi.i += mask
        else:
            pass
        mask = mask >> 1
    print("i {}".format(fi.i))
    print("f {}".format(fi.f))
    return

def main():
    print("lab1")
    f2bistr()
    bistr2f()

if __name__ == '__main__':
    main()
