package com.example.jappanappprogram;

import android.graphics.Path;

class FingerPath {

    int color;
    int strokeWidth;
    Path path;

    FingerPath(int color, int strokeWidth, Path path) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.path = path;
    }
}