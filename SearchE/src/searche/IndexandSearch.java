package searche;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;

public class IndexandSearch {
	@SuppressWarnings("resource")
		
	public static void indexs() throws IOException, ParseException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a search query:");
		String s = in.nextLine();
		long start = System.currentTimeMillis();
		createIndex();
		searchIndex(s);
		long end = System.currentTimeMillis();
		System.out.println("\nTotal time for creating index and searching:" + (end - start)+"\n");
	}

	public static final String FILES_TO_INDEX_DIRECTORY = "filesToIndex";
	public static final String INDEX_DIRECTORY = "indexDirectory";
	public static final String FIELD_PATH = "path";
	public static final String FIELD_CONTENTS = "contents";

	public static void createIndex() throws CorruptIndexException, LockObtainFailedException, IOException {
		Analyzer analyzer = new StandardAnalyzer();
		boolean recreateIndexIfExists = true;
		IndexWriter indexWriter = new IndexWriter(INDEX_DIRECTORY, analyzer, recreateIndexIfExists);
		File dir = new File(FILES_TO_INDEX_DIRECTORY);
		File[] files = dir.listFiles();
		for (File file : files) {
			Document document = new Document();
			String path = file.getCanonicalPath();
			document.add(new Field(FIELD_PATH, path, Field.Store.YES, Field.Index.UN_TOKENIZED));
			Reader reader = new FileReader(file);
			document.add(new Field(FIELD_CONTENTS, reader));
			indexWriter.addDocument(document);
		}
		indexWriter.optimize();
		indexWriter.close();
	}

	@SuppressWarnings("unchecked")
	public static void searchIndex(String searchQuery) throws IOException, ParseException {
		System.out.println("Searching for '" + searchQuery + "'");
		Directory directory = FSDirectory.getDirectory(INDEX_DIRECTORY);
		IndexReader indexReader = IndexReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser queryParser = new QueryParser(FIELD_CONTENTS, analyzer);
		Query query = queryParser.parse(searchQuery);
		Hits hits = indexSearcher.search(query);
		System.out.println("Number of hits: " + hits.length());
		Iterator<Hit> it = hits.iterator();
		while (it.hasNext()) {
			Hit hit = it.next();
			Document document = hit.getDocument();
			String path = document.get(FIELD_PATH);
			System.out.println("Hits:" + path);
		}

	}
}
