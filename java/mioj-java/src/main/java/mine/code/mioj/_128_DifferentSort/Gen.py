# -*- coding: utf-8 -*-

import os
import random

with open('data.txt', 'w') as f:
    print('1000000', file=f, end=' '),
    print('10000000', file=f, end=' '),
    for i in range(10000000):
        print(random.randint(900000, 1000000), file=f, end=' '),
