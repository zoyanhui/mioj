# -*- coding: utf-8 -*-

import os
import random

with open('data.txt', 'w') as f:
    print('1', file=f, end=' '),
    print('50', file=f, end=' '),
    print('100000', file=f),
    for i in range(100000):
        print(i+1, file=f, end=' '),
        print(100, file=f, end=' '),
    print('\n100000', file=f)
