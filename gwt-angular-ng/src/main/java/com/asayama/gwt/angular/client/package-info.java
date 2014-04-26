/**
 * Provides GWT Java wrapper around AngularJS. This module contains the 
 * components in Angular's "ng" module, which is the core of AngularJS 
 * framework. The core module contains enough components to start building a
 * simple application.
 * <p>
 * In order to use the components in this module, the user must add the 
 * following inherit statements in his or code.
 * </p>
 * <pre>{@code
 * <inherits name="com.asayama.gwt.angular.Angular" />
 * }</pre>
 */
package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.JSClosure;
import com.google.gwt.core.client.GWT;

/**
 * Provides interfaces for an object creator. This interface is intended to be
 * used with {@link CreatorGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 */
interface Creator<T> {
    <X extends T> X create(Class<X> klass);
}
interface FilterCreator extends Creator<Filter> {
    static FilterCreator INSTANCE = GWT.create(FilterCreator.class);
    @Override <X extends Filter> X create(Class<X> klass);
}
interface DirectiveCreator extends Creator<Directive> {
    static DirectiveCreator INSTANCE = GWT.create(DirectiveCreator.class);
    @Override <X extends Directive> X create(Class<X> klass);
}
interface ProviderCreator extends Creator<Provider> {
    static ProviderCreator INSTANCE = GWT.create(ProviderCreator.class);
    @Override <X extends Provider> X create(Class<X> klass);
}
interface ServiceCreator extends Creator<Service> {
    static ServiceCreator INSTANCE = GWT.create(ServiceCreator.class);
    @Override <X extends Service> X create(Class<X> klass);
}
interface ControllerCreator extends Creator<Controller> {
    static ControllerCreator INSTANCE = GWT.create(ControllerCreator.class);
    @Override <X extends Controller> X create(Class<X> klass);
}

/**
 * Provides interfaces for an object creator. This interface is intended to be
 * used with {@link DependenciesFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see DependenciesFactoryGenerator
 * @param <T>
 */
interface DependenciesFactory<T> {
    String[] create(T object);
}

interface ProviderDependenciesFactory extends DependenciesFactory<Provider> {
    static ProviderDependenciesFactory INSTANCE = GWT.create(ProviderDependenciesFactory.class);
}

interface ServiceDependenciesFactory extends DependenciesFactory<Service> {
    static ServiceDependenciesFactory INSTANCE = GWT.create(ServiceDependenciesFactory.class);
}

interface ControllerDependenciesFactory extends DependenciesFactory<Controller> {
    static ControllerDependenciesFactory INSTANCE = GWT.create(ControllerDependenciesFactory.class);
}

interface DirectiveDependenciesFactory extends DependenciesFactory<Directive> {
    static DirectiveDependenciesFactory INSTANCE = GWT.create(DirectiveDependenciesFactory.class);
}

interface FilterDependenciesFactory extends DependenciesFactory<Filter> {
    static FilterDependenciesFactory INSTANCE = GWT.create(FilterDependenciesFactory.class);
}

/**
 * Provides interfaces for an object binder. This interface is intended to be
 * used with {@link ScopeBinderFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see ScopeBinderFactoryGenerator
 * @param <T>
 */
interface ScopeBinderFactory<T> {
    JSClosure create(T object);
}

interface ControllerScopeBinderFactory extends ScopeBinderFactory<Controller> {
    static ControllerScopeBinderFactory INSTANCE = GWT.create(ControllerScopeBinderFactory.class);
}

/**
 * Provides interfaces for an object injector. This interface is intended to be
 * used with {@link BinderFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see BinderFactoryGenerator
 * @param <T>
 */
interface BinderFactory<T> {
    JSClosure create(T object);
}

interface ProviderBinderFactory extends BinderFactory<Provider> {
    static ProviderBinderFactory INSTANCE = GWT.create(ProviderBinderFactory.class);
}

interface ServiceBinderFactory extends BinderFactory<Service> {
    static ServiceBinderFactory INSTANCE = GWT.create(ServiceBinderFactory.class);
}

interface ControllerBinderFactory extends BinderFactory<Controller> {
    static ControllerBinderFactory INSTANCE = GWT.create(ControllerBinderFactory.class);
}

interface DirectiveBinderFactory extends BinderFactory<Directive> {
    static DirectiveBinderFactory INSTANCE = GWT.create(DirectiveBinderFactory.class);
}

interface FilterBinderFactory extends BinderFactory<Filter> {
    static FilterBinderFactory INSTANCE = GWT.create(FilterBinderFactory.class);
}