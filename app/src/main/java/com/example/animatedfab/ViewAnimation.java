package com.example.animatedfab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class ViewAnimation {

    public static boolean rotateFab(final View v, boolean rotate) {
        v.animate().setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .rotation(rotate ? 135f : 0f);
        return rotate;
    }

    public static void showIn(final View v) {
        //preparing the view
        v.setVisibility(View.VISIBLE);
        v.setAlpha(0f); //from invisible
        v.setTranslationY(v.getHeight());
        v.setTranslationX(v.getWidth());
        //start animation
        v.animate()
                .setDuration(1000)
                .translationX(0) // from
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .alpha(1f)// to visible
                .start();
    }
    public static void showOut(final View v) {//come in
        v.setVisibility(View.VISIBLE);
        v.setAlpha(1f);
        v.setTranslationY(0); // final
        v.setTranslationX(0);
        v.animate()
                .setDuration(1000)
                .translationY(v.getHeight()) //from
                .translationX(v.getWidth())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        v.setVisibility(View.GONE);
                        super.onAnimationEnd(animation);
                    }
                }).alpha(0f)
                .start();
    }

    public static void init(final View v) {
        v.setVisibility(View.GONE);
        v.setTranslationY(v.getHeight());
        v.setAlpha(0f);
    }
}
