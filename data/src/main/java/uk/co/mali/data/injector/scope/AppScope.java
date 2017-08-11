package uk.co.mali.data.injector.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by alig2 on 09/08/2017.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
