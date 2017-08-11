package uk.co.mali.flickrtest.injector.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by alig2 on 11/08/2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PresenterScope {
}
