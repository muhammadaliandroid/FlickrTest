package uk.co.mali.flickrtest.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by alig2 on 27/07/2017.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface AppScope {
}
