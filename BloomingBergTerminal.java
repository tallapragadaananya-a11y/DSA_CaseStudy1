class TreeNode {
    String ticker;
    TreeNode left, right;

    TreeNode(String ticker) {
        this.ticker = ticker;
    }
}

public class BloomingBergTerminal {

    // Build Balanced BST
    static TreeNode buildBalancedBST(String[] tickers, int start, int end) {

        if (start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(tickers[mid]);

        root.left = buildBalancedBST(tickers, start, mid - 1);
        root.right = buildBalancedBST(tickers, mid + 1, end);

        return root;
    }

    // Search Ticker
    static boolean search(TreeNode root, String symbol) {

        while (root != null) {

            int cmp = symbol.compareTo(root.ticker);

            if (cmp == 0)
                return true;

            if (cmp < 0)
                root = root.left;
            else
                root = root.right;
        }

        return false;
    }

    // Inorder Traversal
    static void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.ticker + " ");
        inorder(root.right);
    }

public static void main(String[] args) {

    String[] tickers = {
        "AAPL", "ADBE", "AMZN", "BABA", "BKNG",
        "COST", "GOOGL", "JPM", "META", "MSFT",
        "NVDA", "ORCL", "TSLA"
    };

    System.out.println("Loading ticker symbols...");
    for(String ticker : tickers) {
        System.out.println("Loaded: " + ticker);
    }

    System.out.println("\nBuilding Balanced BST...");
    TreeNode root = buildBalancedBST(tickers, 0, tickers.length - 1);

    System.out.println("Balanced BST Created Successfully!");

    System.out.println("\nInorder Traversal:");
    inorder(root);

    String searchTicker = "NVDA";

    System.out.println("\n\nSearching for ticker: " + searchTicker);

    TreeNode current = root;

    while(current != null) {

        System.out.println("Visiting Node: " + current.ticker);

        int cmp = searchTicker.compareTo(current.ticker);

        if(cmp == 0) {
            System.out.println(searchTicker + " Found!");
            break;
        }

        if(cmp < 0) {
            System.out.println("Moving Left");
            current = current.left;
        }
        else {
            System.out.println("Moving Right");
            current = current.right;
        }
    }
}
    }