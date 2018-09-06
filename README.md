# AndroidSkinDemo

AndroidSkin is an Android multi theme library which supporting daily colorful theme.


## Android View继承关系图

```
├─── View
│    ├─── TextView
│    │    ├─── android.support.v7.widget.AppCompatTextView
│    │    ├─── EditText
│    │    │    ├─── android.support.v7.widget.AppCompatEditText
│    │    │    │    ├─── android.support.design.widget.TextInputEditText
│    │    │    ├─── AutoCompleteTextView
│    │    │    │    ├─── android.support.v7.widget.AppCompatAutoCompleteTextView
│    │    │    │    ├─── MultiAutoCompleteTextView
│    │    │    │    │    ├─── android.support.v7.widget.AppCompatMultiAutoCompleteTextView
│    │    ├─── Button
│    │    │    ├─── android.support.v7.widget.AppCompatButton
│    │    │    ├─── CompoundButton
│    │    │    │    ├─── RadioButton
│    │    │    │    │    ├─── android.support.v7.widget.AppCompatRadioButton
│    │    │    │    ├─── CheckBox
│    │    │    │    │    ├─── android.support.v7.widget.AppCompatCheckBox
│    │    │    │    ├─── ToggleButton
│    │    │    │    ├─── Switch
│    │    │    │    ├─── android.support.v7.widget.SwitchCompat
│    │    ├─── CheckedTextView
│    │    │    ├─── android.support.v7.widget.AppCompatCheckedTextView
│    │    ├─── TextClock
│    ├─── ProgressBar
│    │    ├─── RatingBar
│    │    │    ├─── android.support.v7.widget.AppCompatRatingBar
│    │    ├─── SeekBar
│    │    │    ├─── android.support.v7.widget.AppCompatSeekBar
│    │    ├─── android.support.v4.widget.ContentLoadingProgressBar
│    ├─── ImageView
│    │    ├─── android.support.v7.widget.AppCompatImageView
│    │    ├─── ImageButton
│    │    │    ├─── android.support.v7.widget.AppCompatImageButton
│    │    │    ├─── android.support.design.widget.FloatingActionButton
│    ├─── ViewStub
│    ├─── ViewGroup
│    │    ├─── LinearLayout
│    │    │    ├─── TableLayout
│    │    │    ├─── TableRow
│    │    │    ├─── RadioGroup
│    │    │    ├─── NumberPicker
│    │    │    ├─── SearchView
│    │    │    ├─── ZoomControls
│    │    │    ├─── android.support.design.widget.AppBarLayout
│    │    │    ├─── android.support.design.widget.TextInputLayout
│    │    ├─── RelativeLayout
│    │    ├─── FrameLayout
│    │    │    ├─── ScrollView
│    │    │    │    ├─── HorizontalScrollView
│    │    │    │    │    ├─── android.support.design.widget.TabLayout
│    │    │    ├─── ViewAnimator
│    │    │    │    ├─── ViewSwitcher
│    │    │    │    │    ├─── TextSwitcher
│    │    │    │    │    ├─── ImageSwitcher
│    │    │    │    ├─── ViewFlipper
│    │    │    ├─── DatePicker
│    │    │    ├─── TimePicker
│    │    │    ├─── CalendarView
│    │    │    ├─── android.support.v4.widget.NestedScrollView
│    │    │    ├─── android.support.design.widget.CollapsingToolbarLayout
│    │    │    ├─── android.support.design.internal.ScrimInsetsFrameLayout
│    │    │    │    ├─── android.support.design.widget.NavigationView
│    │    │    ├─── android.support.design.widget.BottomNavigationView
│    │    │    ├─── android.support.v7.widget.CardView
│    │    ├─── AdapterView
│    │    │    ├─── AbsSpinner
│    │    │    │    ├─── Spinner
│    │    │    │    │    ├─── android.support.v7.widget.AppCompatSpinner
│    │    │    │    ├─── Gallery
│    │    │    ├─── AbsListView
│    │    │    │    ├─── ListView
│    │    │    │    │    ├─── ExpandableListView
│    │    │    │    ├─── GridView
│    │    │    ├─── AdapterViewAnimator
│    │    │    │    ├─── StackView
│    │    │    │    ├─── AdapterViewFlipper
│    │    ├─── GridLayout
│    │    ├─── android.support.v4.widget.DrawerLayout
│    │    ├─── android.support.v4.widget.SlidingPaneLayout
│    │    ├─── android.support.v4.widget.SwipeRefreshLayout
│    │    ├─── android.support.v4.view.ViewPager
│    │    ├─── android.support.v4.view.PagerTitleStrip
│    │    │    ├─── android.support.v4.view.PagerTabStrip
│    │    ├─── android.support.design.widget.CoordinatorLayout
│    │    ├─── Toolbar
│    │    ├─── android.support.v7.widget.Toolbar
│    │    ├─── android.support.v7.widget.SearchView
│    │    ├─── android.support.v7.widget.RecyclerView
│    │    ├─── android.support.constraint.ConstraintLayout
```


## Android View 所有可以换肤的属性(子类拥有父类所有属性)

|View|支持换肤属性|属性说明|
|:---|:---|:---|
|View|android:background<br> android:backgroundTint<br> android:foreground<br> android:foregroundTint<br>|format="reference\|color" format="color" format="reference\|color" format="color"|
|TextView|android:textAppearance<br> android:textColor<br> android:textColorHint<br> android:textColorLink<br> android:textColorHighlight<br> android:textCursorDrawable<br> android:textSelectHandle<br> android:textSelectHandleLeft<br> android:textSelectHandleRight<br> android:drawableLeft<br> android:drawableTop<br> android:drawableRight<br> android:drawableBottom<br> android:drawableStart<br> android:drawableEnd<br> android:drawableTint<br>|format="reference" format="reference\|color" format="reference\|color" format="reference\|color" format="reference\|color" format="reference" format="reference" format="reference" format="reference" format="reference\|color" format="reference\|color" format="reference\|color" format="reference\|color" format="reference\|color" format="reference\|color" format="color"|
|AppCompatTextView|||
|EditText|||
|AppCompatEditText|||
|TextInputEditText|||
|AutoCompleteTextView|android:popupTheme<br> android:dropDownSelector<br>|format="reference" format="reference\|color"|
|AppCompatAutoCompleteTextView|||
|MultiAutoCompleteTextView|||
|AppCompatMultiAutoCompleteTextView|||
|Button|||
|AppCompatButton|||
|CompoundButton|android:button<br> android:buttonTint<br>|format="reference"<br> format="color"|
|RadioButton|||
|AppCompatRadioButton|app:buttonTint<br>|format="color"|
|CheckBox|||
|AppCompatCheckBox|app:buttonTint<br>|format="color"|
|ToggleButton|||
|Switch|android:switchTextAppearance<br> android:thumb<br> android:thumbTint<br> android:track<br> android:trackTint<br>|format="reference"<br> format="reference"<br> format="color"<br> format="reference"<br> format="color"<br>|
|SwitchCompat|app:switchTextAppearance<br>android:thumb<br> app:thumbTint<br> app:track<br> app:trackTint<br>|format="reference"<br> format="reference"<br> format="color"<br> format="reference"<br> format="color"<br>|
|CheckedTextView|android:checkMark<br> android:checkMarkTint<br>|format="reference"<br> format="color"|
|AppCompatCheckedTextView|||
|TextClock|||
|ProgressBar|android:progressDrawable<br> android:indeterminateDrawable<br> android:progressTint<br> android:secondaryProgressTint<br> android:progressBackgroundTint<br> android:indeterminateTint<br>|format="reference"<br>  format="reference"<br> format="color"<br> format="color"<br> format="color"<br> format="color"<br>|
|RatingBar|||
|AppCompatRatingBar|||
|SeekBar|android:thumb<br> android:thumbTint<br> android:tickMark<br> android:tickMarkTint<br>|format="reference"<br> format="color"<br> format="reference"<br> format="color"<br>|
|AppCompatSeekBar|app:tickMark<br> app:tickMarkTint<br>|format="reference"<br> format="color"<br>|
|ContentLoadingProgressBar|||
|ImageView|android:src<br> android:tint<br> app:srcCompat<br>|format="reference\|color" format="color"<br> format="reference"|
|AppCompatImageView|||
|ImageButton|||
|AppCompatImageButton|||
|FloatingActionButton|app:rippleColor<br> app:backgroundTint<br>|format="color"<br> format="color"|
|ViewStub|||
|ViewGroup|android:scrollbarThumbVertical<br> android:scrollbarTrackVertical<br> android:scrollbarThumbHorizontal<br> android:scrollbarTrackHorizontal<br>|format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|LinearLayout|android:divider|format="reference\|color"|
|TableLayout|||
|TableRow|||
|RadioGroup|||
|NumberPicker|solidColor<br> selectionDivider<br> virtualButtonPressedDrawable<br>|format="reference\|color"<br> format="reference"<br> format="reference"<br>|
|SearchView|android:closeIcon<br> android:goIcon<br> android:searchIcon<br> android:searchHintIcon<br> android:voiceIcon<br> android:commitIcon<br> android:queryBackground<br> android:submitBackground<br>|format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|ZoomControls|||
|AppBarLayout|||
|TextInputLayout|android:textColorHint<br> app:hintTextAppearance<br> app:errorTextAppearance<br> app:counterTextAppearance<br> app:counterOverflowTextAppearance<br> app:passwordToggleDrawable<br> app:passwordToggleTint<br>|format="reference\|color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="color"<br>|
|RelativeLayout|||
|FrameLayout|||
|ScrollView|||
|HorizontalScrollView|||
|TabLayout|app:tabBackground<br> app:tabIndicatorColor<br> app:tabTextAppearance<br> app:tabTextColor<br> app:tabSelectedTextColor<br>|format="reference"<br> format="color"<br> format="reference"<br> format="color"<br> format="color"<br>|
|ViewAnimator|||
|ViewSwitcher|||
|TextSwitcher|||
|ImageSwitcher||
|ViewFlipper|||
|DatePicker|headerTextColor<br> headerBackground<br> calendarTextColor<br>|format="color"<br> format="reference\|color"<br> format="color"<br>|
|TimePicker|headerTextColor<br> headerBackground<br> numbersTextColor<br> numbersInnerTextColor<br> numbersBackgroundColor<br> numbersSelectorColor<br>|format="color"<br> format="reference\|color"<br> format="color"<br> format="color"<br> format="color"<br> format="color"<br>|
|CalendarView|android:weekDayTextAppearance<br> android:dateTextAppearance<br>|format="reference"<br> format="reference"<br>|
|NestedScrollView|||
|CollapsingToolbarLayout|app:expandedTitleTextAppearance<br> app:collapsedTitleTextAppearance<br> app:contentScrim<br> app:statusBarScrim<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br>|
|ScrimInsetsFrameLayout|app:insetForeground<br>|format="color\|reference"<br>|
|NavigationView|app:itemTextAppearance<br> app:itemBackground<br> app:itemIconTint<br> app:itemTextColor<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br>|
|BottomNavigationView|app:itemBackground<br> app:itemIconTint<br> app:itemTextColor<br>|format="reference"<br> format="color"<br> format="color"<br>|
|CardView|app:cardBackgroundColor|format="color"|
|AdapterView|||
|AbsSpinner|||
|Spinner|android:popupTheme<br> android:popupBackground<br> android:dropDownSelector<br>|format="reference"<br> format="reference\|color"<br> format="reference"<br>|
|AppCompatSpinner|app:popupTheme<br>|format="reference"<br>|
|Gallery|||
|AbsListView|android:listSelector<br>|format="reference\|color"|
|ListView|android:divider<br>|format="reference\|color"|
|ExpandableListView|android:groupIndicator<br> android:childIndicator<br> android:childDivider<br>|format="reference"<br> format="reference"<br> format="reference\|color"<br>|
|GridView|||
|AdapterViewAnimator|||
|StackView|||
|AdapterViewFlipper|||
|GridLayout|||
|DrawerLayout|||
|SlidingPaneLayout|||
|SwipeRefreshLayout|||
|ViewPager|||
|PagerTitleStrip|||
|PagerTabStrip|||
|CoordinatorLayout|app:statusBarBackground<br>||
|Toolbar|android:titleTextAppearance<br> android:subtitleTextAppearance<br> android:titleTextColor<br> android:subtitleTextColor<br> android:logo<br> android:navigationIcon<br> android:collapseIcon<br> android:popupTheme<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|android.support.v7.widget.Toolbar|app:titleTextAppearance<br> app:subtitleTextAppearance<br> app:titleTextColor<br> app:subtitleTextColor<br> app:logo<br> app:navigationIcon<br> app:collapseIcon<br> app:popupTheme<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|android.support.v7.widget.SearchView|app:closeIcon<br> app:goIcon<br> app:searchIcon<br> app:searchHintIcon<br> app:voiceIcon<br> app:commitIcon<br> app:queryBackground<br> app:submitBackground<br>|format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|RecyclerView|app:fastScrollHorizontalThumbDrawable<br> app:fastScrollHorizontalTrackDrawable<br> app:fastScrollVerticalThumbDrawable<br> app:fastScrollVerticalTrackDrawable<br>|format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|ConstraintLayout|||
