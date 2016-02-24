package com.example.scoop.basics.ui.layoutsample.layout;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import butterknife.Bind;
import butterknife.OnClick;
import com.example.scoop.basics.R;
import com.example.scoop.basics.scoop.AppRouter;
import com.example.scoop.basics.ui.layoutsample.module.NestedViewModule;
import com.lyft.scoop.ViewController;
import com.lyft.scoop.dagger.DaggerScreenScooper;
import javax.inject.Inject;

public class NestedLayoutViewController extends ViewController {

    @Bind(R.id.nested_layout_parent)
    FrameLayout nestedLayoutParent;

    @Bind(R.id.add_view_button)
    Button button;

    private AppRouter appRouter;

    @Inject
    public NestedLayoutViewController(AppRouter appRouter) {
        this.appRouter = appRouter;
    }

    @OnClick(R.id.add_view_button)
    public void addView() {
        DaggerScreenScooper.extend(getScoop(), new NestedViewModule())
                .inflate(R.layout.nested_view, nestedLayoutParent, true);
        button.setVisibility(View.GONE);
    }

    @Override
    protected int layoutId() {
        return R.layout.nested_layout;
    }

    @Override
    public void attach(View view) {
        super.attach(view);
    }

    @Override
    public void detach(View view) {
        super.detach(view);
    }

    @OnClick(R.id.go_back_button)
    public void goBack() {
        appRouter.goBack();
    }
}
