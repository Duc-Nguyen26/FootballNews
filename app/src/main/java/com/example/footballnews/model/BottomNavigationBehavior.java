//package com.example.footballnews.model;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.FrameLayout;
//
//import androidx.annotation.NonNull;
//import androidx.coordinatorlayout.widget.CoordinatorLayout;
//import androidx.core.view.ViewCompat;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<BottomNavigationView>{
//    public  BottomNavigationBehavior(){
//        super();
//    }
//    public  BottomNavigationBehavior(Context context, AttributeSet attributeSet){
//        super(context,attributeSet);
//    }
//
//    @Override
//    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull BottomNavigationView child, @NonNull View dependency) {
//        boolean dependsOn = dependency instanceof FrameLayout;
//        return dependsOn;
//    }
//
//    @Override
//    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View directTargetChild, @NonNull View target, int nestedScrollAxes) {
//        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
//    }
//
//    @Override
//    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed) {
//        if (dy < 0){
//            showBottomNavigation(child);
//        } else if (dy > 0){
//            hideBottomNavigation(child);
//        }
//        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
//    }
//
//    private void hideBottomNavigation(BottomNavigationView view) {
//        view.animate().translationY(view.getHeight());
//    }
//
//    private void showBottomNavigation(BottomNavigationView view) {
//        view.animate().translationY(0);
//    }
//}