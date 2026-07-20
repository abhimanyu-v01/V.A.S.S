# V.A.S.S

Sand Simulation using Java


## Installation

```bash
git clone https://github.com/abhimanyu-v01/V.A.S.S.git
```

### Usage

Install the appropriate JDK and JavaFx versions. 
Then add the JavaFx Lib path under the variable name "JAVAFX_SDK".

Compile it with:

```bash
javac --module-path "$JAVAFX_SDK" --add-modules javafx.controls,javafx.graphics \
  -d out $(find src -name "*.java")
```
Run it with:

```bash
java --module-path "$JAVAFX_SDK" --add-modules javafx.controls,javafx.graphics \
  -cp out com.toji.sandsim.Main
```

## Notes

- Uses Java version 17.0.19
- Uses JavaFx 17.0.19

