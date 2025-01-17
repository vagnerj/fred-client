package cz.active24.client.fred.data.info.keyset;

import cz.nic.xml.epp.keyset_1.StatusType;
import cz.nic.xml.epp.keyset_1.StatusValueType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test for KeysetStatusValueTypeCustomConverter.
 */
public class KeysetStatusValueTypeCustomConverterTest {

    @SuppressWarnings("unchecked")
    @Test
    public void convertKeysetStatusValueTypeToStatusType() {

        List<KeysetStatusValueType> source = new ArrayList<KeysetStatusValueType>(Arrays.asList(KeysetStatusValueType.values()));

        List<StatusType> destination = KeysetStatusValueTypeCustomConverter.toStatusTypes(source);

        Assert.assertEquals(6, destination.size());
        Assert.assertEquals(source.size(), destination.size());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void convertStatusTypeToKeysetStatusValueType() {

        List<StatusType> source = new ArrayList<StatusType>();

        for (StatusValueType value : StatusValueType.values()) {
            StatusType statusType = new StatusType();
            statusType.setLang("en");
            statusType.setS(value);
            source.add(statusType);
        }

        List<KeysetStatusValueType> destination = KeysetStatusValueTypeCustomConverter.toKeysetStatusValueTypes(source);

        Assert.assertEquals(6, destination.size());
        Assert.assertEquals(source.size(), destination.size());
    }

    @Test
    public void convertNull() {

        Object result = KeysetStatusValueTypeCustomConverter.toKeysetStatusValueTypes(null);

        Assert.assertNull(result);
    }
}