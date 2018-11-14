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
│    │    │    │    ├─── android.support.design.button.MaterialButton
│    │    │    ├─── CompoundButton
│    │    │    │    ├─── RadioButton
│    │    │    │    │    ├─── android.support.v7.widget.AppCompatRadioButton
│    │    │    │    ├─── CheckBox
│    │    │    │    │    ├─── android.support.v7.widget.AppCompatCheckBox
│    │    │    │    │    │    ├─── android.support.design.chip.Chip
│    │    │    │    ├─── ToggleButton
│    │    │    │    ├─── Switch
│    │    │    │    ├─── android.support.v7.widget.SwitchCompat
│    │    ├─── CheckedTextView
│    │    │    ├─── android.support.v7.widget.AppCompatCheckedTextView
│    │    ├─── TextClock
│    ├─── ImageView
│    │    ├─── android.support.v7.widget.AppCompatImageView
│    │    ├─── ImageButton
│    │    │    ├─── android.support.v7.widget.AppCompatImageButton
│    │    │    ├─── android.support.design.widget.FloatingActionButton
│    ├─── ProgressBar
│    │    ├─── android.support.v4.widget.ContentLoadingProgressBar
│    │    ├─── RatingBar
│    │    │    ├─── android.support.v7.widget.AppCompatRatingBar
│    │    ├─── SeekBar
│    │    │    ├─── android.support.v7.widget.AppCompatSeekBar
│    ├─── ViewStub
│    ├─── android.support.v7.widget.ViewStubCompat
│    ├─── ViewGroup
│    │    ├─── LinearLayout
│    │    │    ├─── android.support.design.circularreveal.CircularRevealLinearLayout
│    │    │    ├─── TableLayout
│    │    │    ├─── TableRow
│    │    │    ├─── RadioGroup
│    │    │    ├─── NumberPicker
│    │    │    ├─── ZoomControls
│    │    │    ├─── android.support.design.widget.AppBarLayout
│    │    │    ├─── android.support.design.widget.TextInputLayout
│    │    ├─── android.support.v7.widget.LinearLayoutCompat
│    │    │    ├─── SearchView
│    │    │    ├─── android.support.v7.widget.SearchView
│    │    ├─── RelativeLayout
│    │    │    ├─── android.support.design.circularreveal.CircularRevealRelativeLayout
│    │    ├─── FrameLayout
│    │    │    ├─── android.support.design.circularreveal.CircularRevealFrameLayout
│    │    │    ├─── ScrollView
│    │    │    │    ├─── HorizontalScrollView
│    │    │    │    │    ├─── android.support.design.widget.TabLayout
│    │    │    ├─── android.support.v4.widget.NestedScrollView
│    │    │    ├─── ViewAnimator
│    │    │    │    ├─── ViewSwitcher
│    │    │    │    │    ├─── TextSwitcher
│    │    │    │    │    ├─── ImageSwitcher
│    │    │    │    ├─── ViewFlipper
│    │    │    ├─── CalendarView
│    │    │    ├─── DatePicker
│    │    │    ├─── TimePicker
│    │    │    ├─── android.support.design.widget.CollapsingToolbarLayout
│    │    │    ├─── android.support.design.internal.ScrimInsetsFrameLayout
│    │    │    │    ├─── android.support.design.widget.NavigationView
│    │    │    ├─── android.support.design.widget.BottomNavigationView
│    │    │    ├─── android.support.v7.widget.CardView
│    │    │    │    ├─── android.support.design.card.MaterialCardView
│    │    │    │    ├─── android.support.design.circularreveal.cardview.CircularRevealCardView
│    │    │    │    │    ├─── android.support.design.transformation.TransformationChildCard
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
│    │    │    │    ├─── android.support.design.circularreveal.CircularRevealGridLayout
│    │    ├─── Toolbar
│    │    ├─── android.support.v7.widget.Toolbar
│    │    │    ├─── android.support.design.bottomappbar.BottomAppBar
│    │    ├─── android.support.v4.widget.DrawerLayout
│    │    ├─── android.support.v4.widget.SlidingPaneLayout
│    │    ├─── android.support.v4.widget.SwipeRefreshLayout
│    │    ├─── android.support.v4.view.ViewPager
│    │    ├─── android.support.v4.view.PagerTitleStrip
│    │    │    ├─── android.support.v4.view.PagerTabStrip
│    │    ├─── android.support.design.widget.CoordinatorLayout
│    │    │    ├─── android.support.design.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
│    │    ├─── android.support.v7.widget.RecyclerView
│    │    ├─── android.support.design.internal.FlowLayout
│    │    │    ├─── android.support.design.chip.ChipGroup
│    │    ├─── android.support.constraint.ConstraintLayout
```


## Android View 所有可以换肤的属性(子类拥有父类所有属性)

|View|android app 支持换肤属性|属性说明|
|:---|:---|:---|
|View|[√][X] background<br> [√][X] backgroundTint<br> [√][X] foreground<br> [√][X] foregroundTint<br> [√][X] scrollbarThumbVertical<br> [√][X] scrollbarTrackVertical<br> [√][X] scrollbarThumbHorizontal<br> [√][X] scrollbarTrackHorizontal<br>|format="reference\|color"<br> format="color"<br> format="reference\|color"<br> format="color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|TextView|[√][X] textAppearance<br> [√][X] textColor<br> [√][X] textColorHint<br> [√][X] textColorLink<br> [√][X] textColorHighlight<br> [√][X] textCursorDrawable<br> [√][X] textSelectHandle<br> [√][X] textSelectHandleLeft<br> [√][X] textSelectHandleRight<br> [√][X] drawableLeft<br> [√][X] drawableTop<br> [√][X] drawableRight<br> [√][X] drawableBottom<br> [√][X] drawableStart<br> [√][X] drawableEnd<br> [√][X] drawableTint<br>|format="reference"<br> format="reference\|color"<br> format="reference\|color"<br> format="reference\|color"<br> format="reference\|color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference\|color"<br> format="reference\|color"<br> format="reference\|color"<br> format="reference\|color"<br> format="reference\|color"<br> format="reference\|color"<br> format="color"<br>|
|AppCompatTextView|||
|EditText|||
|AppCompatEditText|||
|TextInputEditText|||
|AutoCompleteTextView|[√][√] popupTheme 测试无效<br> [√][X] popupBackground<br> [√][X] dropDownSelector<br>|format="reference"<br> format="reference\|color"<br> format="reference\|color"<br>|
|AppCompatAutoCompleteTextView|||
|MultiAutoCompleteTextView|||
|AppCompatMultiAutoCompleteTextView|||
|Button|||
|AppCompatButton|||
|MaterialButton|app:backgroundTint<br> app:icon<br> app:iconTint<br> app:strokeColor<br> app:rippleColor<br>|format="color"<br> format="reference"<br> format="color"<br> format="color"<br> format="color"<br>|
|CompoundButton|[√][X] button<br> [√][√] buttonTint app:buttonTint无效<br>|format="reference"<br> format="color"<br>|
|RadioButton|||
|AppCompatRadioButton|app:buttonTint 有效, app:buttonTint > android:buttonTint<br>|format="color"|
|CheckBox|||
|AppCompatCheckBox|app:buttonTint 有效, app:buttonTint > android:buttonTint <br>|format="color"|
|Chip|||
|ToggleButton|||
|Switch|[√][√] switchTextAppearance<br> [√][X] thumb<br> [√][√] thumbTint<br> [√][√] track<br> [√][√] trackTint<br> 自定义命名空间无效<br>|format="reference"<br> format="reference"<br> format="color"<br> format="reference"<br> format="color"<br>|
|SwitchCompat|[√][√] switchTextAppearance<br> [√][X] thumb<br> [√][√]thumbTint<br> [√][√] track<br> [√][√] trackTint<br> 除了 thumb 其它的 android 命名空间无效<br>|format="reference"<br> format="reference"<br> format="color"<br> format="reference"<br> format="color"<br>|
|CheckedTextView|[√][X] checkMark<br> [√][X] checkMarkTint<br>|format="reference"<br> format="color"|
|AppCompatCheckedTextView|||
|TextClock|||
|ImageView|[√][X] src<br> [√][X] srcCompat<br> [√][√] tint<br> src > srcCompat, app:tint > android:tint <br>|format="reference\|color" format="reference"<br> format="color"<br>|
|AppCompatImageView|||
|ImageButton|||
|AppCompatImageButton|||
|FloatingActionButton|app:rippleColor<br> app:backgroundTint<br>|format="color"<br> format="color"|
|ProgressBar|[√][X] progressDrawable<br> [√][X] indeterminateDrawable<br> [√][X] progressTint<br> [√][X] secondaryProgressTint<br> [√][X] progressBackgroundTint<br> [√][X] indeterminateTint<br>|format="reference"<br>  format="reference"<br> format="color"<br> format="color"<br> format="color"<br> format="color"<br>|
|ContentLoadingProgressBar|||
|RatingBar|||
|AppCompatRatingBar|||
|SeekBar|[√][X] thumb<br> [√][√] thumbTint app:thumbTint无效<br> [√][√] tickMark<br> [√][√] tickMarkTint<br>|format="reference"<br> format="color"<br> format="reference"<br> format="color"<br>|
|AppCompatSeekBar|||
|ViewStub|||
|ViewStubCompat||
|ViewGroup|||
|LinearLayout|android:divider|format="reference\|color"<br>|
|CircularRevealLinearLayout|||
|TableLayout|||
|TableRow|||
|RadioGroup|||
|NumberPicker|solidColor<br>|format="reference\|color"<br>|
|ZoomControls|||
|AppBarLayout|||
|TextInputLayout|android:textColorHint<br> app:hintTextAppearance<br> app:errorTextAppearance<br> app:counterTextAppearance<br> app:counterOverflowTextAppearance<br> app:passwordToggleDrawable<br> app:passwordToggleTint<br>|format="reference\|color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="color"<br>|
|LinearLayoutCompat|app:divider|format="reference"<br>|
|SearchView|[√][X] closeIcon<br> [√][X] goIcon<br> [√][X] searchIcon<br> [√][X] searchHintIcon<br> [√][X] voiceIcon<br> [√][X] commitIcon<br> [√][X] queryBackground<br> [√][X] submitBackground<br> 自定义命名空间无效<br>|format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|android.support.v7.widget.SearchView|[√][X] closeIcon<br> [√][X] goIcon<br> [√][X] searchIcon<br> [√][X] searchHintIcon<br>[√][X] voiceIcon<br> [√][X] commitIcon<br> [√][X] queryBackground<br> [√][X] submitBackground<br>  android 命名空间无效<br>|format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|RelativeLayout|||
|CircularRevealRelativeLayout|||
|FrameLayout|||
|CircularRevealFrameLayout|||
|ScrollView|||
|HorizontalScrollView|||
|TabLayout|app:tabBackground<br> app:tabIndicatorColor<br> app:tabTextAppearance<br> app:tabTextColor<br> app:tabSelectedTextColor<br>|format="reference"<br> format="color"<br> format="reference"<br> format="color"<br> format="color"<br>|
|NestedScrollView|||
|ViewAnimator|||
|ViewSwitcher|||
|TextSwitcher|||
|ImageSwitcher||
|ViewFlipper|||
|CalendarView|[√][X] weekDayTextAppearance<br> [√][X] dateTextAppearance<br>|format="reference"<br> format="reference"<br>|
|DatePicker|[√][X] headerBackground<br> [√][X] calendarTextColor<br>|format="reference\|color"<br> format="color"<br>|
|TimePicker|[√][X] headerBackground<br> [√][X] headerTextColor<br> [√][X] numbersBackgroundColor<br> [√][X] numbersInnerTextColor<br> [√][X] numbersTextColor<br> [√][X] numbersSelectorColor<br>|format="reference\|color"<br> format="color"<br> format="color"<br> format="color"<br> format="color"<br> format="color"<br>|
|CollapsingToolbarLayout|app:expandedTitleTextAppearance<br> app:collapsedTitleTextAppearance<br> app:contentScrim<br> app:statusBarScrim<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br>|
|ScrimInsetsFrameLayout|app:insetForeground<br>|format="color\|reference"<br>|
|NavigationView|app:itemTextAppearance<br> app:itemBackground<br> app:itemIconTint<br> app:itemTextColor<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br>|
|BottomNavigationView|app:itemBackground<br> app:itemIconTint<br> app:itemTextColor<br>|format="reference"<br> format="color"<br> format="color"<br>|
|CardView|app:cardBackgroundColor|format="color"|
|MaterialCardView|app:strokeColor|format="color"|
|CircularRevealCardView|||
|TransformationChildCard|||
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
|CircularRevealGridLayout|||
|Toolbar|[√][√] titleTextAppearance<br> [√][√] subtitleTextAppearance<br> [√][√] titleTextColor<br> [√][√] subtitleTextColor<br> [√][√] logo<br> [√][√] navigationIcon<br> [√][√] collapseIcon<br> [√][√] popupTheme<br> 自定义命名空间无效<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|android.support.v7.widget.Toolbar| [√][√] titleTextAppearance<br> [√][√] subtitleTextAppearance<br> [√][√] titleTextColor<br> [√][√] subtitleTextColor<br> [√][√] logo<br>  [√][√] navigationIcon<br> [√][√] collapseIcon<br> [√][√] popupTheme<br> android 命名空间无效<br>|format="reference"<br> format="reference"<br> format="color"<br> format="color"<br> format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|BottomAppBar|app:backgroundTint<br>||
|DrawerLayout|||
|SlidingPaneLayout|||
|SwipeRefreshLayout|||
|ViewPager|||
|PagerTitleStrip|||
|PagerTabStrip|||
|CoordinatorLayout|app:statusBarBackground<br>||
|CircularRevealCoordinatorLayout|||
|RecyclerView|[X][√] fastScrollHorizontalThumbDrawable<br> [X][√] fastScrollHorizontalTrackDrawable<br> [X][√] fastScrollVerticalThumbDrawable<br> [X][√] fastScrollVerticalTrackDrawable<br>|format="reference"<br> format="reference"<br> format="reference"<br> format="reference"<br>|
|FlowLayout|||
|ChipGroup|||
|ConstraintLayout|||


## Android View 所有可以换肤的属性限制说明(最低sdkVersion = 14)

### sdkVersion = 17

|View|支持换肤属性|属性说明|
|:---|:---|:---|
|TextView|android:drawableStart<br> android:drawableEnd<br>|都在 4.2 加入; 低版本使用也能显示, 但是会报错误; 官方建议 drawableLeft 与 drawableStart, drawableRight 与 drawableEnd 同时使用. |

### sdkVersion = 21

|View|支持换肤属性|属性说明|
|:---|:---|:---|
|View|android:backgroundTint<br> android:foregroundTint<br>|都在 5.0 加入; 不过 android:foregroundTint 在 5.0 只支持 FrameLayout, View 及其子类 6.0 才支持. |
|AutoCompleteTextView|android:popupTheme|在 5.0 加入; android:popupTheme 和 app:popupTheme 测试无效.|
|CompoundButton|android:buttonTint|在 5.0 加入; 子类 AppCompatRadioButton 和 AppCompatCheckBox 支持 app:buttonTint, 而且兼容 5.0 之前版本; android:buttonTint 和 app:buttonTint 同时存在, app:buttonTint 会覆盖 android:buttonTint. |
|Switch|android:thumbTint|在 5.0 加入; 自定义命名空间如 app 无效; android:thumbTint 在 6.0 才有效. |
|SwitchCompat|app:thumbTint<br> app:trackTint<br>|用来 兼容 5.0 之前的 Switch; 低版本可以使用 SwitchCompat代替 Switch. |
|CheckedTextView|android:checkMarkTint|在 5.0 加入; android:checkMarkTint 在 7.0 才有效.|
|ProgressBar|android:indeterminateTint<br> android:progressTint<br> android:secondaryProgressTint<br> android:progressBackgroundTint<br>|都在 5.0 加入;|
|SeekBar|android:thumbTint<br>|在 5.0 加入;|

### sdkVersion = 23

|View|支持换肤属性|属性说明|
|:---|:---|:---|
|View|android:foreground|在 6.0 加入; 之前其实也有, 不过只支持 FrameLayout; 低版本如果要使用该属性可以使用 FrameLayout 代替 View. |
|TextView|android:drawableTint|在 6.0 加入; 对于 android:drawableStart 和 android:drawableEnd 的 Drawable 资源 tint 在 7.0 才有效. |
|Switch|android:trackTint|在 6.0 加入;|

### sdkVersion = 24

|View|支持换肤属性|属性说明|
|:---|:---|:---|
|SeekBar|android:tickMark<br> android:tickMarkTint<br>|在 7.0 加入;|
