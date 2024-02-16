import requests
from bs4 import BeautifulSoup

def simple_web_scraper(url):
    # Send a GET request to the URL
    response = requests.get(url)
    
    # Check if the request was successful (status code 200)
    if response.status_code == 200:
        # Parse the HTML content of the page
        soup = BeautifulSoup(response.content, 'html.parser')
        
        # Find all the <a> tags (links) on the page
        links = soup.find_all('a')
        
        # Print the URLs of all the links found
        for link in links:
            print(link.get('href'))
    else:
        print("Failed to fetch web page. Status code:", response.status_code)

def main():
    # URL of the website to scrape
    url = "https://example.com"
    
    # Call the simple_web_scraper function with the URL
    simple_web_scraper(url)

if __name__ == "__main__":
    main()
