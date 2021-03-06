package cz.abclinuxu.datoveschranky.common.entities;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 
 * Výsledek hašovací funkce (haš + algoritmus). Tato třída je neměnná.
 * 
 * @author Vaclav Rosecky &lt;xrosecky 'at' gmail 'dot' com&gt;
 */
import java.util.Arrays;
public class Hash implements Serializable {

    private static final long serialVersionUID = 2L;
    
    private final byte[] hash;
    private final String algorithm;

    public Hash(String algorithm, byte[] hash) {
        if (algorithm == null) {
            throw new NullPointerException("algorithm");
        }
        if (hash == null) {
            throw new NullPointerException("hash");
        }
        this.algorithm = algorithm;
        this.hash = hash;
    }

    /**
     * Vrátí jméno hašovací funkce, v případě ISDS to jsou SHA-1 či SHA-2.
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Výsledek hašovací funkce.
     */
    public byte[] getHash() {
        return hash;
    }
    
    @Override
    public String toString() {
        return algorithm + " " + new BigInteger(1, hash).toString(16);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Hash other = (Hash) obj;
        return Arrays.equals(hash, other.hash);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(hash);
    }
}
