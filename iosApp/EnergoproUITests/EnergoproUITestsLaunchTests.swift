import XCTest

// swiftlint:disable:next type_name
final class EnergoproUITestsLaunchTests: XCTestCase {
    override func setUp() {
        super.setUp()
        continueAfterFailure = false
    }

    func testLaunch() throws {
        let app = XCUIApplication()
        app.launch()
    }
}
