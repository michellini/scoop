package com.lyft.scoop.dagger;

import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ScreenScooper;

public class DaggerScreenScooper extends ScreenScooper {

    @Override
    protected Scoop addServices(Scoop.Builder scoopBuilder, Screen screen, Scoop parentScoop) {
        DaggerInjector parentDagger = DaggerInjector.fromScoop(parentScoop);

        DaggerModule daggerModule = screen.getClass().getAnnotation(DaggerModule.class);

        if(daggerModule == null) {
            return scoopBuilder.service(DaggerInjector.SERVICE_NAME, parentDagger).build();
        }

        DaggerInjector screenInjector;

        try {
            final Object [] modules = new Object[daggerModule.values().length];
            for (int i = 0; i < modules.length; i ++) {
                modules[i] = daggerModule.values()[i].newInstance();
            }
            screenInjector = parentDagger.extend(modules);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to instantiate module for screen: " + screen.getClass().getSimpleName(), e);
        }

        return scoopBuilder
                .service(DaggerInjector.SERVICE_NAME, screenInjector).build();
    }

    public static Scoop extend(final Scoop parentScoop, final Object... modules) {
        final Screen parentScreen = Screen.fromScoop(parentScoop);
        final Scoop.Builder scoopBuilder = new Scoop.Builder(parentScreen.getClass().getSimpleName(), parentScoop)
                .service(Screen.SERVICE_NAME, parentScreen);
        final DaggerInjector daggerInjector = DaggerInjector.fromScoop(parentScoop).extend(modules);

        return scoopBuilder
                .service(DaggerInjector.SERVICE_NAME, daggerInjector).build();
    }
}
