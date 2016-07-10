# Domain Driven Design Support Tool

We will develop the Eclipse Plugin to support the development of Domain Driven Design.
Currently, it has published the following Eclipse Plugin.

- DDD template create Plugin

## DDD template create Plugin

- Create Domain Driven Design Template Classes of Selected Domain Class.

 - Identity class
 - Detail class
 - Criteria class
 - FirstClassCollection class
 - Summary class
 - Repository interface
 - Type enumeration

## Requirements

- java6 or later(java8 is recommended)

- eclipse 3.4 or later(4.5 is recommended)

## Binary Download
https://osdn.jp/projects/dddsupport/releases/

## Build

```
1. Get source.
git clone https://github.com/nakag/dddsupport.git

2. Open plugin.xml and select Overview tab.

3. Export plugin by using Export Wizard.
```

## Installation
1. Put jp.osdn.dddsupport.basegenerator_0.1.0.qualifier.jar into dropins directory.
1. Run eclipse.

## Usage
1. Right click on Java Source(Package explorer or Java Editor).
1. DDD Support->Create DDD Templates(or alt + shift + F8).

## Issues
https://github.com/nakag/dddsupport/issues

## Licence
ASL
