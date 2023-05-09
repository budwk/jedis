package com.budwk.jedis.search;

import static com.budwk.jedis.search.SearchProtocol.SearchKeyword.DIALECT;
import static com.budwk.jedis.search.SearchProtocol.SearchKeyword.DISTANCE;
import static com.budwk.jedis.search.SearchProtocol.SearchKeyword.EXCLUDE;
import static com.budwk.jedis.search.SearchProtocol.SearchKeyword.INCLUDE;
import static com.budwk.jedis.search.SearchProtocol.SearchKeyword.TERMS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.args.Rawable;
import com.budwk.jedis.params.IParams;
import com.budwk.jedis.util.KeyValue;

public class FTSpellCheckParams implements IParams {

  private Collection<Map.Entry<String, Rawable>> terms;
  private Integer distance;
  private Integer dialect;

  public FTSpellCheckParams() {
  }

  public static FTSpellCheckParams spellCheckParams() {
    return new FTSpellCheckParams();
  }

  /**
   * Specifies an inclusion (INCLUDE) of a custom dictionary.
   */
  public FTSpellCheckParams includeTerm(String dictionary) {
    return addTerm(dictionary, INCLUDE);
  }

  /**
   * Specifies an exclusion (EXCLUDE) of a custom dictionary.
   */
  public FTSpellCheckParams excludeTerm(String dictionary) {
    return addTerm(dictionary, EXCLUDE);
  }

  /**
   * Specifies an inclusion (INCLUDE) or exclusion (EXCLUDE) of a custom dictionary.
   */
  private FTSpellCheckParams addTerm(String dictionary, Rawable type) {
    if (this.terms == null) {
      this.terms = new ArrayList<>();
    }
    this.terms.add(KeyValue.of(dictionary, type));
    return this;
  }

  /**
   * Maximum Levenshtein distance for spelling suggestions (default: 1, max: 4).
   */
  public FTSpellCheckParams distance(int distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Selects the dialect version under which to execute the query.
   */
  public FTSpellCheckParams dialect(int dialect) {
    this.dialect = dialect;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {

    if (terms != null) {
      terms.forEach(kv -> args.add(TERMS).add(kv.getValue()).add(kv.getKey()));
    }

    if (distance != null) {
      args.add(DISTANCE).add(distance);
    }

    if (dialect != null) {
      args.add(DIALECT).add(dialect);
    }
  }
}
