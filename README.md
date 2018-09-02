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
│    ├─── ViewGroup
│    │    ├─── LinearLayout
│    │    │    ├─── TableLayout
│    │    │    ├─── TableRow
│    │    │    ├─── RadioGroup
│    │    │    ├─── NumberPicker
│    │    │    ├─── SearchView
│    │    │    ├─── android.support.design.widget.AppBarLayout
│    │    │    ├─── android.support.design.widget.TextInputLayout
│    │    ├─── RelativeLayout
│    │    ├─── FrameLayout
│    │    │    ├─── ScrollView
│    │    │    │    ├─── HorizontalScrollView
│    │    │    │    │    ├─── android.support.design.widget.TabLayout
│    │    │    ├─── ViewSwitcher
│    │    │    │    ├─── TextSwitcher
│    │    │    │    ├─── ImageSwitcher
│    │    │    ├─── DatePicker
│    │    │    ├─── TimePicker
│    │    │    ├─── CalendarView
│    │    │    ├─── android.support.v4.widget.NestedScrollView
│    │    │    ├─── android.support.design.widget.CollapsingToolbarLayout
│    │    │    ├─── android.support.design.internal.ScrimInsetsFrameLayout
│    │    │    │    ├─── android.support.design.widget.NavigationView
│    │    │    ├─── android.support.design.widget.BottomNavigationView
│    │    │    ├─── android.support.v7.widget.CardView
│    │    ├─── AbsSpinner
│    │    │    ├─── Spinner
│    │    │    │    ├─── android.support.v7.widget.AppCompatSpinner
│    │    │    ├─── Gallery
│    │    ├─── AbsListView
│    │    │    ├─── ListView
│    │    │    │    ├─── ExpandableListView
│    │    │    ├─── GridView
│    │    ├─── StackView
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
