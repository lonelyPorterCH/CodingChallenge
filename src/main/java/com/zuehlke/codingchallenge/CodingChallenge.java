package com.zuehlke.codingchallenge;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CodingChallenge {
    private final SomeService someService = new SomeService();

    /**
     * Returns all SomeObject, SomeObject with the same Identifier are merged with value containing all
     * values comma separated.
     */
    public List<SomeObject> getMergedObjects() {
        List<SomeObject> data = someService.getData();

        //Grouping SomeObject by Identifier, each List entry is another list of entries with the same
        // identifier (but different values)
        Collection<List<SomeObject>> groupedObjects = data
            .stream()
            .collect(Collectors.groupingBy(SomeObject::identifier, Collectors.toList()))
            .values();
        return mapGroupedObjects(groupedObjects);
    }

    /**
     * maps the List of grouped Objects into a single List of SomeObject with joined values.
     * Sports the SomeObject by identifier (descending)
     */
    private List<SomeObject> mapGroupedObjects(Collection<List<SomeObject>> groupedObjects) {
        return groupedObjects.stream().map(objectList -> {
            //Index is not important since all of them have the same values (except the one we want to merge)
            //and the first entry should always be present
            SomeObject someObject = objectList.get(0);

            String mergedValues = objectList.stream()
                .map(SomeObject::value)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

            return copyWithValue(someObject, mergedValues);
        })
        .sorted(Comparator.comparing(SomeObject::identifier))
        .toList();
    }

    private SomeObject copyWithValue(SomeObject someObject, String mergedValues) {
        return new SomeObject(
            someObject.identifier(),
            mergedValues,
            someObject.valueA(),
            someObject.valueB(),
            someObject.valueC()
        );
    }
}
