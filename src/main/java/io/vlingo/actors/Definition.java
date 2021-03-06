// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.actors;

import java.util.ArrayList;
import java.util.List;

public final class Definition {
  public static final List<Object> NoParameters = new ArrayList<Object>();

  public static Definition has(final Class<? extends Actor> type, final List<Object> parameters) {
    return new Definition(type, parameters);
  }

  public static Definition has(
          final Class<? extends Actor> type,
          final List<Object> parameters,
          final String actorName) {
    return new Definition(type, parameters, actorName);
  }

  public static Definition has(
          final Class<? extends Actor> type,
          final List<Object> parameters,
          final Actor parent,
          final String actorName) {
    return new Definition(type, parameters, parent, actorName);
  }

  public static Definition has(
          final Class<? extends Actor> type,
          final List<Object> parameters,
          final String mailboxName,
          final String actorName) {
    return new Definition(type, parameters, null, mailboxName, actorName);
  }

  public static Definition has(
          final Class<? extends Actor> type,
          final List<Object> parameters,
          final Actor parent,
          final String mailboxName,
          final String actorName) {
    return new Definition(type, parameters, parent, mailboxName, actorName);
  }

  public static List<Object> parameters(Object... parameters) {
    final List<Object> allParameters = new ArrayList<Object>();
    for (final Object param : parameters) {
      allParameters.add(param);
    }
    return allParameters;
  }

  private final String mailboxName;
  private final String actorName;
  private final List<Object> parameters;
  private final Actor parent;
  private final Class<? extends Actor> type;

  public Definition(final Class<? extends Actor> type, final List<Object> parameters) {
    this(type, parameters, null, null, null);
  }

  public Definition(
          final Class<? extends Actor> type,
          final List<Object> parameters,
          final String actorName) {
    
    this(type, parameters, null, null, actorName);
  }

  public Definition(
          final Class<? extends Actor> type,
          final List<Object> parameters,
          final Actor parent,
          final String actorName) {
    
    this(type, parameters, parent, null, actorName);
  }

  public Definition(
          final Class<? extends Actor> type,
          final List<Object> parameters,
          final Actor parent,
          final String mailboxName,
          final String actorName) {
    
    this.type = type;
    this.parameters = parameters;
    this.parent = parent;
    this.mailboxName = mailboxName;
    this.actorName = actorName;
  }

  public String actorName() {
    return actorName;
  }

  public String mailboxName() {
    return mailboxName;
  }

  public List<Object> parameters() {
    return new ArrayList<Object>(internalParameters());
  }

  public Actor parent() {
    return parent;
  }

  public Actor parentOr(final Actor defaultParent) {
    return parent != null ? parent : defaultParent;
  }

  public Class<? extends Actor> type() {
    return type;
  }

  protected List<Object> internalParameters() {
    return parameters;
  }
}
