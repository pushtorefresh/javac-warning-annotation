package com.pushtorefresh.javac_warning_annotation.internal;

import com.pushtorefresh.javac_warning_annotation.Warning;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Collections;
import java.util.Set;

import static javax.tools.Diagnostic.Kind.WARNING;

/*
 * Copyright (C) 2014 Pushtorefresh, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/**
 * @author Artem Zinnatullin [artem.zinnatullin@pushtorefresh.com]
 */
public class WarningAnnotationProcessor extends AbstractProcessor {

    @Override public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Warning.class.getName());
    }

    @Override public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Warning.class);

        for (Element element : elements) {
            processingEnv.getMessager().printMessage(WARNING, "@Warning: " + element.getAnnotation(Warning.class).value(), element);
        }

        return true;
    }
}
